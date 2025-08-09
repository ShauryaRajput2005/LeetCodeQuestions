import requests
import os
from datetime import datetime, timezone, timedelta

USERNAME = os.getenv("LEETCODE_USERNAME") or "your_leetcode_username_here"
IST = timezone(timedelta(hours=5, minutes=30))

QUERY = """
query recentAcSubmissions($username: String!, $limit: Int!) {
  recentAcSubmissionList(username: $username, limit: $limit) {
    title
    titleSlug
    timestamp
  }
}
"""

def fetch_recent(username, limit=200):
    r = requests.post("https://leetcode.com/graphql", json={"query": QUERY, "variables": {"username": username, "limit": limit}})
    r.raise_for_status()
    j = r.json()
    return j.get("data", {}).get("recentAcSubmissionList", [])

def solved_today(subs):
    today = datetime.now(IST).date()
    seen = set()
    out = []
    for s in subs:
        ts = s.get("timestamp")
        if not ts:
            continue
        d = datetime.fromtimestamp(int(ts), IST).date()
        if d == today:
            slug = s["titleSlug"]
            if slug in seen:
                continue
            seen.add(slug)
            out.append((s["title"], slug))
    return out

def read_readme():
    with open("README.md", "r", encoding="utf-8") as f:
        return f.readlines()

def already_have_today(lines, date_str):
    for i, line in enumerate(lines):
        if line.startswith("| Date"):
            if i + 2 < len(lines):
                first = lines[i + 2].strip()
                return first.startswith(f"| {date_str} |")
    return False

def insert_row(lines, date_str, links_md):
    for i, line in enumerate(lines):
        if line.startswith("| Date"):
            lines.insert(i + 2, f"| {date_str} | {', '.join(links_md)} | |\n")
            return lines
    return lines

def main():
    subs = fetch_recent(USERNAME, limit=200)
    solved = solved_today(subs)
    if not solved:
        print("No accepted problems solved today.")
        return
    links = [f"[{t}](https://leetcode.com/problems/{slug}/)" for t, slug in solved]
    date_str = datetime.now(IST).strftime("%b %d, %Y")
    lines = read_readme()
    if already_have_today(lines, date_str):
        print("README already has today's entry.")
        return
    lines = insert_row(lines, date_str, links)
    with open("README.md", "w", encoding="utf-8") as f:
        f.writelines(lines)
    print(f"Inserted {len(links)} problems for {date_str} into README.md")

if __name__ == "__main__":
    main()


import sys
if __name__ == "__main__":
    if "--debug" in sys.argv:
        print("Running in debug mode...")
        # Replace this with the function or code that fetches and prints your submissions
        # Example:
        submissions = get_recent_submissions()  # Or however your script fetches data
        print(submissions)
    else:
        # Your normal script flow
        main()


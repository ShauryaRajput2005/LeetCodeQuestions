import java.util.*;

class Solution {

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;
            Point p = (Point) o;
            return x == p.x && y == p.y;
        }

        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public int robotSim(int[] com, int[][] ob) {

        HashSet<Point> set = new HashSet<>();
        for (int[] o : ob) {
            set.add(new Point(o[0], o[1]));
        }

        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        int d = 0, x = 0, y = 0;
        int max = 0;

        for (int cmd : com) {

            if (cmd == -1) {
                d = (d + 1) % 4; 
            } 
            else if (cmd == -2) {
                d = (d + 3) % 4; 
            } 
            else {
                for (int i = 0; i < cmd; i++) {
                    int nx = x + dir[d][0];
                    int ny = y + dir[d][1];

                    if (set.contains(new Point(nx, ny))) break;

                    x = nx;
                    y = ny;

                    max = Math.max(max, x*x + y*y);
                }
            }
        }

        return max;
    }
}
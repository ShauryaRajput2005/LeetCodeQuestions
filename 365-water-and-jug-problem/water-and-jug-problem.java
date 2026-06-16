import java.util.*;

class Solution {

    Set<String> visited = new HashSet<>();

    public boolean canMeasureWater(int x, int y, int target) {

        if (target > x + y)
            return false;

        return dfs(0, 0, x, y, target);
    }

    private boolean dfs(int a, int b, int x, int y, int target) {

        if (a + b == target)
            return true;

        String state = a + "," + b;

        if (visited.contains(state))
            return false;

        visited.add(state);

        // Fill X
        if (dfs(x, b, x, y, target))
            return true;

        // Fill Y
        if (dfs(a, y, x, y, target))
            return true;

        // Empty X
        if (dfs(0, b, x, y, target))
            return true;

        // Empty Y
        if (dfs(a, 0, x, y, target))
            return true;

        // Pour X -> Y
        int pourXY = Math.min(a, y - b);
        if (dfs(a - pourXY, b + pourXY, x, y, target))
            return true;

        // Pour Y -> X
        int pourYX = Math.min(b, x - a);
        if (dfs(a + pourYX, b - pourYX, x, y, target))
            return true;

        return false;
    }
}
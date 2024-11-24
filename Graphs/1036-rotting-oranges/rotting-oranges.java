class Solution {
    static class Pair {
        int x;
        int y;
        int t;

        Pair(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }

    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        HashSet<String> map = new HashSet<>();
        int freshOranges = 0;

        // Initialize the queue and count fresh oranges
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                    map.add(i + "," + j);
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        // Base case: if no fresh oranges exist
        if (freshOranges == 0) return 0;

        int[][] direc = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int time = 0;

        // Perform BFS
        while (!q.isEmpty()) {
            Pair pair = q.remove();
            time = pair.t;

            for (int[] directions : direc) {
                int x1 = pair.x + directions[0];
                int y1 = pair.y + directions[1];

                // Check bounds and conditions
                if (x1 >= 0 && x1 < grid.length && y1 >= 0 && y1 < grid[0].length &&
                    grid[x1][y1] == 1 && !map.contains(x1 + "," + y1)) {

                    q.add(new Pair(x1, y1, pair.t + 1));
                    map.add(x1 + "," + y1);
                    freshOranges--;
                    grid[x1][y1] = 2; // Mark as rotten
                }
            }
        }

        // If there are fresh oranges left, return -1
        return freshOranges == 0 ? time : -1;
    }
}
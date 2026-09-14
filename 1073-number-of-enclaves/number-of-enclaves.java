class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        
        // 1. Add ONLY boundary land cells to the queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Check if cell is on the boundary
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                    if (grid[i][j] == 1) {
                        q.add(new int[]{i, j});
                        vis[i][j] = true;
                    }
                }
            }
        }
        
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        // 2. BFS to mark all land cells that can reach the boundary
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int row = node[0];
            int col = node[1];
            
            for (int[] dir : directions) {
                int r = row + dir[0];
                int c = col + dir[1];
                
                // If neighbor is valid land and not visited yet
                if (r >= 0 && r < n && c >= 0 && c < m && grid[r][c] == 1 && !vis[r][c]) {
                    vis[r][c] = true;
                    q.add(new int[]{r, c});
                }
            }
        }
        
        // 3. Count remaining unvisited land cells (enclaves)
        int enclaveCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    enclaveCount++;
                }
            }
        }
        
        return enclaveCount;
    }
}
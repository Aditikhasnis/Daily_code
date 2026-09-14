class Solution {
    static class node implements Comparable<node> {
        int dis ;
        int row ;
        int col ;
        int routeMaximum;
        public node (int dis , int row , int col , int routeMaximum){
            this.dis=dis;
            this.row=row;
            this.col=col;
            this.routeMaximum=routeMaximum;
        }

         @Override
         public int compareTo(node o) {
             return Integer.compare(this.dis,o.dis);
         }
     }
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<node> q = new PriorityQueue<>();

        q.add(new node(0,0,0,0));
        int n = heights.length;
        int m = heights[0].length;
        boolean[][] vis = new boolean[n][m];
        int routeMax;
        int minEffort = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            node curr = q.poll();
            int cr = curr.row;
            int cc = curr.col;
            int cd = curr.dis;
            int rw = curr.routeMaximum;
            if(vis[cr][cc]==true){
                continue;
            }
            int[][] directions = new int[][]{
                    {0,1},
                    {0,-1},
                    {1,0},
                    {-1,0}
            };
            vis[cr][cc]=true;
            routeMax=Math.max(rw,cd);
            for(int[] dir :  directions){
                int x = cr + dir[0];
                int y = cc + dir[1];

                if(x>=0 && x<n && y>=0 && y<m && !vis[x][y]){
                    int aiff = Math.abs(heights[cr][cc]-heights[x][y]);
                    q.add(new node(aiff,x,y,routeMax));
                  if(x==n-1 && y==m-1){
                      routeMax=Math.max(aiff,routeMax);
                      minEffort=Math.min(routeMax,minEffort);
                    }

                }

            }
        }
        return minEffort==Integer.MAX_VALUE ? 0 : minEffort;

    }
}
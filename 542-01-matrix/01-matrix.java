class Solution {
    public int[][] updateMatrix(int[][] mat) {
       int n = mat.length;
       int m = mat[0].length;
       int[][] dist = new int[n][m];
       Queue<int[]> q = new LinkedList<>();
       for(int i=0;i<n;i++) {
           Arrays.fill(dist[i], -1);
       }
       for(int i=0;i<n;i++){
           for(int j=0;j<m;j++)
           {
               if(mat[i][j]==0){
                  dist[i][j]=0;
                  q.add(new int[]{i,j});
               }
           }
       }

       while(!q.isEmpty()){
           int[] node = q.poll();
           int[][] axis = new int[][]{
                   {0,1},{0,-1},{-1,0},{1,0}
           };
           for(int[] dir : axis){
               int nx=node[0]+dir[0];
               int ny=node[1]+dir[1];
               if(nx>=0 && nx<n && ny>=0 && ny<m && dist[nx][ny]==-1){
                   dist[nx][ny] = dist[node[0]][node[1]]+1;
                   q.add(new int[]{nx,ny});
               }
           }
       }
       return dist; 
    }
}
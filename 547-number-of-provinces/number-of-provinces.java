class Solution {
      static class unionFind{

        static int[] parent ;
        unionFind(int n){
            parent = new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
            }
        }

        public static int find(int i){
            if (parent[i] != i) {
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }

        public static void union(int i , int j){
            int first = find(i);
            int second = find(j);
            parent[second]=first;
        }
    }
    public int findCircleNum(int[][] isConnected) {
       int rows = isConnected[0].length;
       int cols = isConnected.length;
       unionFind uc = new unionFind(rows+2);
       for(int i=0;i<cols;i++){
        for(int j=0;j<rows;j++){
           if(isConnected[i][j]==1){
               unionFind.union(i+1,j+1);
           }
        }
       }
       int res=0;
       for(int i=1;i<rows+2;i++){
         if(unionFind.parent[i]==i){
            res++;
         }
       }
       return res-1;
    }
}
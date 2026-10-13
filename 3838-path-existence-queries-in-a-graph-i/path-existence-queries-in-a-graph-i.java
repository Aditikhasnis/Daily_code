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
    
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int i=1;
         unionFind uc = new unionFind(n);
         while (i<nums.length){
             if((Math.abs(nums[i-1]-nums[i])<=maxDiff)){
                 unionFind.union(i,i-1);
                
             }
             i++;
         }
         int len = queries.length;
         boolean[] res = new boolean[len];
         int count=0;
         for(int[] q : queries){
             res[count]= unionFind.find(q[0]) == unionFind.find(q[1]);
             count++;
         }
         return res;
    }
}
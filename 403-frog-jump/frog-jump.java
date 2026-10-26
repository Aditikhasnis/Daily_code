class Solution {
    private static int[] kmap = new int[]{+1,0,-1};
    public boolean dfs(HashMap<Integer,Integer> map , int index,int[] stones , int prevK,int[][] dp){
        if(index==stones.length-1){
            return true ;
        }
        if(dp[index][prevK]!=-1){
            return dp[index][prevK]==1;
        }
        boolean frogJumped = false;
        for(int i=0;i<kmap.length;i++){
            int canJump = prevK+kmap[i];
            int nextStone = stones[index] + canJump;
            if(map.containsKey(nextStone) && stones[index]!=nextStone ){
                if(dfs(map,map.get(nextStone),stones,canJump,dp)){
                    frogJumped = true;
                    return true;
                }
            }
        }
        dp[index][prevK]= frogJumped ? 1 : 0; 

        return false;
    }
    
    public boolean canCross(int[] stones) {
       HashMap<Integer,Integer> map = new HashMap<>();
       for(int i=0;i<stones.length;i++ ){
           map.putIfAbsent(stones[i],i);
       }
       int[][] dp = new int[stones.length][stones.length];
       for(int[] d : dp){
        Arrays.fill(d,-1);
       }

       return dfs(map, 0 ,stones,0 ,dp);
    }
}
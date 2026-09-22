class Solution {
   public HashMap<Integer,Integer> map = new HashMap<>();
    public int dfs(int n ){

        if(n<=1){
            return 1;
        }
        if(map.containsKey(n)){
            return map.get(n);

        }
        int ans=1 + Math.min(n%2+dfs(n/2) , n%3 + dfs(n/3));
        map.put(n,ans);
        return ans;
    }
    public int minDays(int n) {

        return dfs(n);
        
    }
}
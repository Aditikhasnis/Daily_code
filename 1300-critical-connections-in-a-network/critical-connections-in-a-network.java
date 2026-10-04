class Solution {
    private List<List<Integer>> bridges = new ArrayList<>();
    private int timer=0;
    public  void  dfs(int src , List<List<Integer>> conn , int parent , int[] dist , int[] low ,boolean[] vis){
     if(vis[src]==true){
         return ;
     }
     dist[src]=timer++;
     low[src]=dist[src];
     vis[src]=true;
     for(int i=0;i<conn.get(src).size();i++){
         int adjNode = conn.get(src).get(i);
         if(!vis[adjNode]){
             dfs(adjNode,conn,src,dist,low,vis);
         }
         else {
             if(parent!=adjNode){
                 low[src]=Math.min(low[adjNode],low[src]);
             }
         }
     }
     if(low[parent]>low[src]){
         low[parent]=low[src];
     }
     else if(dist[parent]<low[src]){
         bridges.add(Arrays.asList(src,parent));
     }


    }
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        List<List<Integer>> conn = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            conn.add(new ArrayList<>());
        }

        // Build adjacency list
        for (List<Integer> edge : connections) {
            int u = edge.get(0);
            int v = edge.get(1);

            conn.get(u).add(v);
            conn.get(v).add(u);
        }
        int[] dist = new int[n];
        int[] low = new int[n];
        boolean[] vis = new boolean[n];

        dfs(0,conn,0,dist,low,vis);

        return bridges;
    }
}
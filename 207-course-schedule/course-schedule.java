class Solution {
    public ArrayList<Integer>[] createGraph(int n,int[][] prerequisites){
        ArrayList<Integer>[] adj = new ArrayList[n+1];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }

        for(int[] arr : prerequisites){
         adj[arr[0]].add(arr[1]);
        }
        return adj;
    }
    private boolean dfs(ArrayList<Integer>[] graph , HashSet<Integer> vis , boolean[] stk , int curr){
        if(stk[curr]){
            return true;
        }
        if(vis.contains(curr)){
            return false;
        }
        stk[curr]=true;
        vis.add(curr);
        for(int i=0;i< graph[curr].size();i++)
        {
            if(dfs(graph,vis,stk,graph[curr].get(i))){
                return true;
            }
        }
        stk[curr]=false;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
     ArrayList<Integer>[] adj = createGraph(numCourses,prerequisites);
     HashSet<Integer> vis = new HashSet<>();
     boolean[] stack = new boolean[numCourses];
     boolean result =  false;
    for(int i=0;i< prerequisites.length;i++){
        if(dfs(adj,vis,stack,prerequisites[i][0])){
            return false;
        }
     }
     return true;

    }
}
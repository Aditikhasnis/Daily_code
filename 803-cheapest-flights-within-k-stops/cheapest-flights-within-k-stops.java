class Solution {
    static class Pair{
        int src ;
        int dest;
        int dist ;
        int stops;
        Pair(int src , int dest , int dist , int stops){
            this.src=src;
            this.dest=dest;
            this.dist=dist;
            this.stops=stops;
        }
        Pair(int src , int dist , int stops){
            this .src = src;
            this.dist=dist;
            this.stops=stops;
        }
    }
    public HashMap<Integer, List<Pair>>  createGraph(int n ,int[][] flights){
        HashMap<Integer,List<Pair>> adj = new HashMap<>();
        for(int i=0;i<n;i++){
            adj.put(i, new ArrayList<>());
        }
        for(int[] flight : flights){
             adj.get(flight[0]).add(new Pair(flight[0],flight[1],flight[2],0));
        }
        return adj;
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer,List<Pair>> adj = createGraph(n,flights);
        PriorityQueue<Pair> q = new PriorityQueue<>(Comparator.comparingInt(a->a.dist));
        q.add(new Pair(src,dst,0,0));
        int[][] distance = new int[n][k+2];
        for(int[] dist : distance)
        Arrays.fill(dist,Integer.MAX_VALUE);
        distance[src][0]=0;
        int ans=Integer.MAX_VALUE;
        while(!q.isEmpty()){

            Pair source = q.poll();
               if (source.dist != distance[source.src][source.stops]) {
        continue;
    }

            for(int i=0;i<adj.get(source.src).size();i++){
                Pair node = adj.get(source.src).get(i);
                int newStop = source.stops+1;
                if(newStop <=k && node.dest!=dst) {
                    if(distance[node.dest][newStop] > distance[node.src][source.stops] + node.dist){
                        distance[node.dest][newStop]= distance[node.src][source.stops] + node.dist;
                        q.add(new Pair(node.dest, distance[node.dest][newStop],newStop));
                    }
                   
                }
                else if (node.dest==dst && newStop<=k+1){
                    if(distance[node.dest][newStop] > distance[node.src][source.stops] + node.dist){
                        distance[node.dest][newStop]= distance[node.src][source.stops] + node.dist;
                    }
                    ans=Math.min(distance[node.dest][newStop],ans);
                }

            }
        }

        return ans!=Integer.MAX_VALUE? ans:-1;
    }
}
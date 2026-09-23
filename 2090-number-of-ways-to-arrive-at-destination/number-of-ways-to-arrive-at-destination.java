class Solution {
    public static class Pair{
        int src;
        int dest;
        long time;
        Pair(int src , int dest , long time){
            this.src=src;
            this.dest=dest;
            this.time=time;
        }
          Pair(int src , long time){
            this.src=src;
            this.time=time;
        }
    }

    public HashMap<Integer, List<Pair>> createGraph(int n, int[][] roads ){
        HashMap<Integer, List<Pair>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i,new ArrayList<>());
        }
        for(int[] road : roads){
            map.get(road[0]).add(new Pair(road[0],road[1],road[2]));
            map.get(road[1]).add(new Pair(road[1],road[0],road[2]));
        }
        return map;
    }
    public int countPaths(int n, int[][] roads) {
        PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingLong(a->a.time));
        HashMap<Integer,List<Pair>> adj = createGraph(n,roads);
        long[] distance = new long[n];
        long[] ways = new long[n];
        Arrays.fill(distance,Long.MAX_VALUE);
        ways[0]=1;
        distance[0]=0;
        queue.add(new Pair(0,0));
        while(!queue.isEmpty()){
            Pair curr = queue.poll();
            if (curr.time > distance[curr.src]) {
    continue;
}
            for(int i=0;i< adj.get(curr.src).size();i++){

                Pair node = adj.get(curr.src).get(i);
                if(distance[node.dest]> node.time + distance[node.src]){
                    distance[node.dest]=node.time+distance[node.src];
                    ways[node.dest]=ways[node.src];
                    queue.add(new Pair(node.dest,distance[node.dest]));
                }
                else if( distance[node.dest]== node.time + distance[node.src]){
                    ways[node.dest]=(ways[node.dest]+ways[node.src])%1_000_000_007L;
                }

            }
        }

      return (int)ways[n-1];
    }
}
class Solution {
    static  class Pair {
        Integer key ;
        Integer time ;
        Pair(Integer key, Integer time ){
            this.key=key;
            this.time=time;
        }
    }
    private List<Integer> result = new ArrayList<>();
    private Set<Integer> vis = new LinkedHashSet<>();
    private HashMap<Integer,List<Pair>> createGraph(int[][]meetings){
         HashMap<Integer,List<Pair>> _map = new HashMap<>();
        for(int[] arr : meetings){
            if(!_map.containsKey(arr[0])){
                _map.put(arr[0],new ArrayList<>());
            }
            _map.get(arr[0]).add(new Pair(arr[1],arr[2]));
            if(!_map.containsKey(arr[1])){
                _map.put(arr[1], new ArrayList<>());
            }
            _map.get(arr[1]).add(new Pair(arr[0],arr[2]));
        }
        return _map;

    }
    
private void bfs(
        int n,int first , 
        PriorityQueue<Pair> q,
        HashMap<Integer, List<Pair>> adj,
        List<Integer> result) {

    int[] earliestTime = new int[n];
    Arrays.fill(earliestTime, Integer.MAX_VALUE);

    earliestTime[0] = 0;
    earliestTime[first]=0;

    while (!q.isEmpty()) {

        Pair curr = q.poll();

        // Ignore an outdated PQ entry
        if (curr.time > earliestTime[curr.key]) {
            continue;
        }

        if (!adj.containsKey(curr.key)) {
            continue;
        }

        for (Pair node : adj.get(curr.key)) {

            if (node.time >= curr.time &&
                node.time < earliestTime[node.key]) {

                earliestTime[node.key] = node.time;

                q.add(new Pair(node.key, node.time));
            }
        }
    }

    for (int i = 0; i < n; i++) {
        if (earliestTime[i] != Integer.MAX_VALUE ) {
            result.add(i);
        }
        
    }
}

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
    HashMap<Integer,List<Pair>> adj = createGraph(meetings);
    PriorityQueue<Pair> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.time));
    q.add(new Pair(0,0));
    q.add(new Pair(firstPerson,0));
    bfs(n,firstPerson,q,adj,result);
    return result;
    }
}
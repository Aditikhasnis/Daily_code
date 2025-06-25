// Inc Aditi 21st June Saturday 2025 >3

class Solution {
    static class DSU{
        private int[] parent;
        private int[] size;
        public DSU(int V)
        {
            parent=new int[V];
            size=new int[V];
            for(int i=0;i<V;i++)
            {
                parent[i]=i;
                size[i]=1;
            }
        }

        public int findParent(int u)
        {
            if (parent[u]==u)
            {
                return u;
            }
            return parent[u]=findParent(parent[u]);
        }
        public void union(int u , int v)
        {
            int parentOfu=findParent(u);
            int parentOfv=findParent(v);
            if(size[parentOfu] > size[parentOfv])
            {
                parent[parentOfv]=parentOfu;
                size[parentOfu]+=size[v];
            }
            else{
                parent[parentOfu]=parentOfv;
                size[parentOfv]+=size[u];
            }

        }
    }
    static class Edge{
        String src ;
        String dest;
        Edge(String src , String dest)
        {
            this.src=src;
            this.dest=dest;
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
    final  HashMap<String,Integer> _parentMap = new HashMap<>();
    int V=accounts.size();
    DSU dsu = new DSU(V+1);
    ArrayList<String>[] Graph = new ArrayList[V+1];
    for(int i=0;i<V+1;i++)
    {
        Graph[i]= new ArrayList<>();
    }
    for(int i=0;i<V;i++)
    {
        for(int j=1;j<accounts.get(i).size();j++)
        {
            String email_you_know=accounts.get(i).get(j);
            if(!_parentMap.containsKey(email_you_know))
            {
                _parentMap.put(email_you_know,i);
            }
            else
            {
                dsu.union(i,_parentMap.get(email_you_know));
            }

        }
    }

    for(Map.Entry<String,Integer> map : _parentMap.entrySet())
    {
        String key = map.getKey();
        Graph[dsu.findParent(map.getValue())].add(key);
    }
    List<List<String>> result = new ArrayList<>();
    
    for(int i=0;i<Graph.length;i++)
    {
        if(Graph[i].size()==0)
        {
            continue;
        }

        Collections.sort(Graph[i]);
        List<String> sublist = new ArrayList<>();
        sublist.add(accounts.get(i).get(0));
        for(String mails : Graph[i])
        {
            sublist.add(mails);
        }
        result.add(sublist);
    }



      return result;
        
    }
}
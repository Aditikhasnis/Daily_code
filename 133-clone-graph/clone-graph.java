/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private  Node dfs(Node node , HashMap<Integer,Node> vis ){
        if(vis.containsKey(node.val)){
            return vis.get(node.val);
        }
        Node newNode = new Node(node.val);
        vis.put(node.val,newNode);
        for(int i=0;i<node.neighbors.size();i++){
            newNode.neighbors.add(dfs(node.neighbors.get(i),vis));  
        }
        return newNode;
    }
    public Node cloneGraph(Node node) {
        if(node==null){
            return null;
        }
        return dfs(node , new HashMap<Integer,Node>());
    }
}
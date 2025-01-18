/**
 * // Definition for a _Node.
 * function _Node(val, neighbors) {
 *    this.val = val === undefined ? 0 : val;
 *    this.neighbors = neighbors === undefined ? [] : neighbors;
 * };
 */

/**
 * @param {_Node} node
 * @return {_Node}
 */
var cloneGraph = function(node) {

    let node_new=node;
    if(node_new===null)
    {
        return null;
    }
    const vis = new Map();

    const dfs =(current_node)=>{
        if(vis.has(current_node))
        {
            return vis.get(current_node);
        }

        const new_clone=new Node(current_node.val);
        vis.set(current_node, new_clone);

        for(let neighbors of current_node.neighbors)
        {
            new_clone.neighbors.push(dfs(neighbors));
        }

        return new_clone;

    };

    return dfs(node_new);


    
};
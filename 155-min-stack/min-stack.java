class MinStack {
   
    class Node{
        int data;     
        Node next;
        int mini;
        Node(int val)
        {
            this.data=val;
            this.next=null;
            this.mini=Integer.MAX_VALUE;       
        }
    }
    Node top ;
    public MinStack() {

        this.top=null;
    }
    
    public void push(int val) {

        Node node = new Node(val);
        if(top==null)
        {
            top=node; 
            node.mini=node.data;         

        }
        else{

            node.next=top;
            node.mini=Math.min(top.mini,node.data);
            top=node;
        }



        

        


        
    }
    
    public void pop() {

        Node new_node=top;
        top=top.next;
        new_node.next=null;

        
    }
    
    public int top() {
        if(top==null)
        {
            return -1;
        }

        return top.data;
        
    }
    
    public int getMin() {


        return top==null? -1 : top.mini;
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
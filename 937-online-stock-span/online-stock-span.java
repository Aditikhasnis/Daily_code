class StockSpanner {
      
    Stack<int[]> q ;
    public StockSpanner() {
        q = new Stack<>();
    }
    
    public int next(int price) {
       int span=1;
       while(!q.isEmpty() && q.peek()[0]<=price)
       {
        span+=q.pop()[1];
       }
       q.push(new int[] {price, span});
       return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
class MinStack:

    def __init__(self):
        self.stk=[]
        self.minStack=[]
        self.min=float('inf')
        

    def push(self, val: int) -> None:

        self.stk.append(val)
        if val<=self.min:

            self.min=val
            self.minStack.append(val)
        

    def pop(self) -> None:

       value=self.stk.pop()
       if value==self.min:        
           if self.minStack:
            self.minStack.pop()
            if self.minStack:
                self.min=self.minStack[-1]
            else:
                self.min=float('inf')


           




        

    def top(self) -> int:


        return self.stk[-1] if self.stk else None 
        

    def getMin(self) -> int:


        return self.min
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
class MyQueue:

    def __init__(self):
        self.stk1=[]
        self.stk2=[]

    def push(self, x: int) -> None:


        while self.stk1:

            self.stk2.append(self.stk1.pop())
        
        self.stk2.append(x)

        while self.stk2:

            self.stk1.append(self.stk2.pop())

    def pop(self) -> int:

        if self.stk1:
            return self.stk1.pop()
        

    def peek(self) -> int:

        if self.stk1:
            return self.stk1[-1]
        

    def empty(self) -> bool:

        if len(self.stk1)==0:
            return True
        return False
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
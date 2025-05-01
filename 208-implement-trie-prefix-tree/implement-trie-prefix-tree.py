class Trie:
    class Node:
        def __init__(self):
            self.children={}
            self.isComplete=False

    def __init__(self):
        self.root=Trie.Node()
        

    def insert(self, word: str) -> None:
        node =self.root
        for char  in word:
            if char not in node.children:
                node.children[char]=Trie.Node()
            node=node.children[char]
        node.isComplete=True
        

        

    def search(self, word: str) -> bool:
        node=self.root
        for char in word:
            if char not in node.children:
                return False
            node=node.children[char]
        return node.isComplete

        

    def startsWith(self, prefix: str) -> bool:

        node =self.root
        for char in prefix:
            if char not in node.children:
                return False
            node=node.children[char]

        return True
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
class Solution:
    def stringMatching(self, words: List[str]) -> List[str]:


        # for i in range(len(words)):
        #     parent=words[i]
        #     for j in range(i+1,len(words)):
        words.sort(key=len)
        res=[]
        print(words)
        for i in range(len(words)):
            parent=words[i]
            for j in range(i+1,len(words)):
                if parent in words[j]:
                    res.append(parent)
                    break

        

        return res

        
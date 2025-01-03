class Solution:
    def vowelStrings(self, words: List[str], queries: List[List[int]]) -> List[int]:

        vowels=set()
        vowels.add('a')
        vowels.add('e')
        vowels.add('i')
        vowels.add('o')
        vowels.add('u')

        prefix_sum=[0]*(len(words))
        for i in range(len(words)):
            if words[i][0] in vowels and words[i][len(words[i])-1] in vowels:
                if i>=1:
                    prefix_sum[i]=prefix_sum[i-1]+1
                else:
                    prefix_sum[i]=1
            else:
                prefix_sum[i]=prefix_sum[i-1]

        res=[]
        for u,v in queries:
            if u>=1:
                res.append(prefix_sum[v]-prefix_sum[u-1])
            else:
                res.append(prefix_sum[v])

        return res


        
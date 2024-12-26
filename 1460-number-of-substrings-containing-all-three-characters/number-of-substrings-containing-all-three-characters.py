class Solution:
    def numberOfSubstrings(self, s: str) -> int:

        vis={}
        l,r=0,0
        count=0
        n=len(s)
        while r<n:
            vis[s[r]]=vis.get(s[r],0)+1
            r+=1
            while len(vis)==3 :
                count+= (n-(r)+1)
                vis[s[l]]-=1
                if vis[s[l]]==0:
                    del vis[s[l]]
                l+=1
            

        if len(vis)==3:
            count+=1
        return count



        
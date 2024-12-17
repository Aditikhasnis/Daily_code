class Solution:
    def characterReplacement(self, s: str, k: int) -> int:

        count=0
        vis={}
        l,r=0,0
        n=len(s)
        maxi=0
        while r<n:
            vis[s[r]]=vis.get(s[r],0)+1
            
            while (r-l+1)-max(vis.values())>k:
                vis[s[l]]-=1
                if vis[s[l]]==0:
                    del vis[s[l]]
                l+=1
            maxi=max(maxi,r-l+1)
            r+=1
        return maxi











        
class Solution:
    def loudAndRich(self, richer: List[List[int]], quiet: List[int]) -> List[int]:
        def create(richer , quiet):
            adj={}
            for u,v in richer:
                if v not in adj:
                    adj[v]=[]
                adj[v].append(u)
            return adj

        def topSort(g,res,vis,src):
            if src in vis:
                return 
            vis.add(src)
            for neigh in g.get(src,[]):
                if neigh not in vis:
                    topSort(g,res,vis,neigh)
                if quiet[res[neigh]]<quiet[res[src]]:
                    res[src]=res[neigh]
            
            return 


        g=create(richer,quiet)
        res = [i for i in range(len(quiet))]
        vis=set()
        for i in range(len(quiet)):
            if i not in vis:
                topSort(g,res,vis,i)
        return res
        
from collections import deque, defaultdict

class Solution:
    def minimumDiameterAfterMerge(self, edges1: List[List[int]], edges2: List[List[int]]) -> int:

        def create(edge):
            adj=defaultdict(list)
            for u,v in edge:
                adj[u].append(v)
                adj[v].append(u)
            return adj
        

        def bfs(adj,node):
            q=deque()
            q.append(node)
            vis={node}
            far_node=node
            while q:           
                n=len(q)
                for _ in range(n):
                    curr=q.popleft()   
                    for i in adj.get(curr,[]):
                        if i not in vis:
                            vis.add(i)
                            q.append(i)
                            far_node=i
            
            q=deque()
            q.append(far_node)
            vis={far_node}
            hops=0
            while q:
                n=len(q)
                for _ in range(n):
                    curr=q.popleft()
                    for i in adj.get(curr,[]):
                        if i not in vis:
                            vis.add(i)
                            q.append(i)
                hops+=1
            
            return hops-1
        t1=create(edges1)
        t2=create(edges2)
        dia1=bfs(t1,0)
        dia2=bfs(t2,0)
        return max(dia1,dia2,(dia1+1)//2+(dia2+1)//2+1)
            

        
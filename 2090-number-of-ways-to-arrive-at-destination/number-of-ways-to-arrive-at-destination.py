class Solution:
    def graph(self, roads):
        adj={}
        for u,v,i in roads:
            if u not in adj:
                adj[u] = []
            if v not in adj:
                adj[v] = []
            adj[u].append((v,i))
            adj[v].append((u,i))
        return adj

    def shortestPath(self, V , adj , src):
        heap=[]
        dist=[float('inf')]*V
        dist[src]=0
        ways=[0]*V
        ways[src]=1
        heapq.heappush(heap,(0,src))
        while heap:
            distance , u = heapq.heappop(heap)
            if distance > dist[u]:
                continue
            for dest,weight in adj.get(u,[]):
                if weight+dist[u]< dist[dest]:
                    dist[dest]=weight+dist[u]
                    ways[dest] = ways[u]
                    heapq.heappush(heap,(dist[dest],dest))
                   
                elif (dist[u]+weight)==dist[dest]:
                    ways[dest]=(ways[dest]+ways[u])%(10**9 + 7)


        return ways[V-1]

    def countPaths(self, n: int, roads: List[List[int]]) -> int:

        g=self.graph(roads) 
        return self.shortestPath(n,g,0)





        
class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:


        distance={k:0}
        def create(times):
            g=defaultdict(list)
            for items in times:
                g[items[0]].append((items[2],items[1]))

            return g

        def dijakstras(g,src):
            heap=[]
            heapq.heappush(heap,(0,src))
            vis=set()
            distance[src]=0
            while heap:
                curr_distance,u=heapq.heappop(heap)
                vis.add(u)
                for w,v in g.get(u,[]):
                    if v in vis:
                        continue                    
                    if v not in distance or curr_distance + w < distance[v]:
                        distance[v]=curr_distance + w
                        heapq.heappush(heap,(distance[v],v))
      
         
        g=create(times)
        dijakstras(g,k)

        return max(distance.values()) if len(distance)==n else -1
from collections import defaultdict
from typing import List

class Solution:
    def minTime(self, n: int, edges: List[List[int]], hasApple: List[bool]) -> int:
        def create(edges):
            adj = defaultdict(list)
            for edge in edges:
                adj[edge[0]].append(edge[1])
                adj[edge[1]].append(edge[0])
            return adj

        def dfs(node, parent, hasApple, adj):
            time = 0

            for child in adj[node]:
                if child == parent:  
                    continue

                child_time = dfs(child, node, hasApple, adj)
                if child_time > 0 or hasApple[child]:
                    time += child_time + 2
            return time

        g = create(edges)


        return dfs(0, -1, hasApple, g)
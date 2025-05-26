from collections import defaultdict
import heapq

class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        graph = defaultdict(list)
        for u, v, cost in flights:
            graph[u].append((v, cost))

        heap = [(0, src, 0)]  # (cost, current_node, stops)
        visited = dict()  # (node, stops): cost

        while heap:
            cost, node, stops = heapq.heappop(heap)

            if node == dst:
                return cost

            if stops > k:
                continue

            for neighbor, price in graph[node]:
                new_cost = cost + price
                if (neighbor, stops + 1) not in visited or new_cost < visited[(neighbor, stops + 1)]:
                    visited[(neighbor, stops + 1)] = new_cost
                    heapq.heappush(heap, (new_cost, neighbor, stops + 1))

        return -1

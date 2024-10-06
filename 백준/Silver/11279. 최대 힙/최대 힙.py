import heapq
import sys
input = sys.stdin.readline

max_heap = []
n = int(input())

for _ in range(n):
    x =  int(input())
    if x == 0:
        if len(max_heap) > 0:
            print(heapq.heappop(max_heap)[1])
            continue
        else:
            print(0)
            continue
    heapq.heappush(max_heap, (-x, x))
import heapq
import sys
input = sys.stdin.readline

heap = []
n = int(input())
zeros = 0

for _ in range(n):
    x =  int(input())
    if x == 0:
        if len(heap) > 0:
            print(heapq.heappop(heap))
            continue
        else:
            print(0)
            continue
    heapq.heappush(heap, x)
import sys

n = int(sys.stdin.readline())
ropes = []

for _ in range(n):
    ropes.append(int(sys.stdin.readline()))
ropes.sort()
max_weight = ropes.pop()

weight_arr = [max_weight]
for r in ropes:
    weight_arr.append(r*n)
    n -= 1

max_weight = max(weight_arr)
print(max_weight)
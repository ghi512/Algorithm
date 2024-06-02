T = int(input())
arr = []
for i in range(T):
    arr.append(list(map(int, input().split())))
arr.sort()
for k in arr:
    print(k[0], k[1])
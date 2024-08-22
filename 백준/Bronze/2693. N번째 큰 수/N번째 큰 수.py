T = int(input())
arr = []

for i in range(T):
    arr.append(list(map(int, input().split())))
    arr[i].sort()
    print(arr[i][7])
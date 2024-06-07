n = int(input())
arr = []
for i in range(n):
    arr.append(list(input().split()))
    arr[i][0] = int(arr[i][0])
arr.sort(key=lambda x:x[0])

for j in range(n):
    print(arr[j][0], arr[j][1])
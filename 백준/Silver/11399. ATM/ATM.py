n = int(input())
arr = list(map(int, input().split()))
arr.sort()

for i in range(n-1):
    arr[i+1] = arr[i] + arr[i+1]

print(sum(arr))
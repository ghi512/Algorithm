import sys
input = sys.stdin.readline

n = int(input())
arr = [[0 for j in range(2)] for i in range(n)]

for k in range(n):
    arr[k][0], arr[k][1] = map(int, input().split())
arr.sort(key=lambda x: (x[1], x[0]))

for m in range(n):
    print(arr[m][0], arr[m][1])
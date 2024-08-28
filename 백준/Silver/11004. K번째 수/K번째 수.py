import sys
input = sys.stdin.readline

n,k = map(int, input().split())
arr = sorted(list(map(int, input().split())))

print(arr[k-1])
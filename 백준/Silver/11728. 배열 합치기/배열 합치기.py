import sys

input = sys.stdin.readline

n,m = map(int, input().split())
arr_a = list(map(int, input().split()))
arr_b = list(map(int, input().split()))

res = arr_a + arr_b
res.sort()

print(*res)
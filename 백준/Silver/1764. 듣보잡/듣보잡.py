import sys

input = sys.stdin.readline

n,m = map(int, input().split())

a = set()
for i in range(n):
    a.add(input())

b = set()
for i in range(n):
    b.add(input())

result = sorted(list(a & b)) # 교집합
print(len(result))
print(''.join(result), end='')
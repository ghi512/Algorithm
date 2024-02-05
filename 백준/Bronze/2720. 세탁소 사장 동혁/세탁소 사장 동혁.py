import sys
input = sys.stdin.readline

t = int(input())

for _ in range(t):
    change = int(input())
    q,change = divmod(change, 25)
    d,change = divmod(change, 10)
    n,change = divmod(change, 5)
    p = change
    print(q, d, n, p)

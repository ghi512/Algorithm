n,m = map(int, input().split())
li = list(range(n))

for _ in range(m):
    i,j = map(int, input().split())
    li[i-1], li[j-1] = li[j-1], li[i-1]

for x in range(n):
    print(int(li[x])+1, end=' ')
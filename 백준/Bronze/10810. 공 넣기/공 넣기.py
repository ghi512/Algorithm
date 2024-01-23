n,m = map(int, input().split())
bucket = [0 for i in range(n)]
for _ in range(m):
    i,j,k = map(int, input().split())
    for x in range(i-1,j):
        bucket[x] = k
for l in range(len(bucket)):
    print(bucket[l], end=' ')
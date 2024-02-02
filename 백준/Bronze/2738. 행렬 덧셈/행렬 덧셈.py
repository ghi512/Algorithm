n,m = map(int, input().split())

A,B = [], []

for _ in range(n):
    row = list(map(int, input().split()))
    A.append(row)
for _ in range(n):
    row = list(map(int, input().split()))
    B.append(row)
for i in range(n):
    for j in range(m):
        print(A[i][j] + B[i][j], end=' ')
    print()
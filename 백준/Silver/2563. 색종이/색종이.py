import sys
input = sys.stdin.readline

numOfPapers = int(input()) # 색종이 개수
bigPaper = [[0] * 100 for _ in range(100)]

for _ in range(numOfPapers):
    x,y = map(int, input().split())
    for i in range(x, x+10):
        for j in range(y, y+10):
            bigPaper[i][j] = 1

res = 0
for i in range(100):
    res += bigPaper[i].count(1)
print(res)

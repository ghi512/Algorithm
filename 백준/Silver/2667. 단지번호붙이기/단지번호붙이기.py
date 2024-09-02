import sys

# dfs 함수 정의
def dfs(x,y):
    if not visited[x][y] and graph[x][y] == '1':
        visited[x][y] = True
        global houses
        houses += 1
        for d in direction:
            nx = x + d[0]
            ny = y + d[1]
            if nx<0 or nx>=n or ny<0 or ny>=n:
                continue
            if not visited[nx][ny] and graph[nx][ny] == '1':
                dfs(nx,ny)
    else:
        visited[x][y] = True

# 입력 및 초기화
input = sys.stdin.readline
n = int(input())

graph = []
visited = [[False] * (n+1) for _ in range(n+1)]
for _ in range(n):
    graph.append(list(input().strip()))

answer = []
idx = 0
houses = 0
direction = [[-1,0], [1,0], [0,-1], [0,1]]

# dfs 수행
for i in range(n):
    for j in range(n):
        dfs(i,j)
        if houses > 0:
            answer.append(houses)
            houses = 0
            idx += 1

print(len(answer))
answer.sort()
for a in answer:
    print(a)
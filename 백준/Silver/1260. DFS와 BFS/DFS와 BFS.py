import sys

# dfs 함수 정의
def dfs(idx):
    global visited
    visited[idx] = True
    print(idx, end=' ')
    for next in range(1, N+1):
        if not visited[next] and graph[idx][next]:
            dfs(next)

# bfs 함수 정의
def bfs():
    global q, visited
    while q:
        cur = q.pop(0)
        visited[cur] = True
        print(cur, end=' ')
        for next in range(1, N+1):
            if not visited[next] and graph[cur][next]:
                visited[next] = True
                q.append(next)

# 입력 및 초기화
input = sys.stdin.readline
N, M, V = map(int, input().split())

graph = [[False] * (N+1) for _ in range(N+1)]
visited = [False] * (N+1)

for _ in range(M):
    a,b = map(int, input().split())
    graph[a][b] = True
    graph[b][a] = True

# dfs
dfs(V)
print()

# bfs
visited = [False] * (N+1)
q = [V]
bfs()
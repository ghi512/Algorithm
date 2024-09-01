import sys

# dfs 함수 정의
def dfs(idx):
    global answer
    visited[idx] = True
    for next in range(1, computer+1):
        if not visited[next] and graph[idx][next]:
            answer += 1
            dfs(next)

# 입력 및 초기화
input = sys.stdin.readline
computer = int(input())
connection = int(input())
answer = 0

graph = [[False] * (computer + 1) for _ in range(computer+1)]
visited = [False] * (computer + 1)

for _ in range(connection):
    a,b = map(int, input().split())
    graph[a][b] = True
    graph[b][a] = True

# dfs 실행
visited[1] = True
dfs(1)
print(answer)
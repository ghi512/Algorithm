import sys
input = sys.stdin.readline

N, M = map(int, input().rstrip().split())

arr = []
for i in range(N):
    arr.append(list(input().rstrip()))

leftUp = None
rightDown = None

for i in range(N):
    if leftUp != None:
        break
    for j in range(M):
        if arr[i][j] == "#":
            leftUp = (i, j)
            break

for i in range(N - 1, -1, -1):
    if rightDown != None:
        break
    for j in range(M - 1, -1, -1):
        if arr[i][j] == "#":
            rightDown = (i, j)
            break

mid = ((leftUp[0] + rightDown[0]) // 2, (leftUp[1] + rightDown[1]) // 2)

if arr[leftUp[0]][mid[1]] == ".":
    print("UP")
elif arr[mid[0]][leftUp[1]] == ".":
    print("LEFT")
elif arr[mid[0]][rightDown[1]] == ".":
    print("RIGHT")
elif arr[rightDown[0]][mid[1]] == ".":
    print("DOWN")
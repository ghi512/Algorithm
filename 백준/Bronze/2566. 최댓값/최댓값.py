arr = []
for _ in range(9):
    row = list(map(int, input().split()))
    arr.append(row)

maxNum = -1; maxRow = -1; maxCol = -1
for i in range(9):
    for j in range(9):
        if arr[i][j] > maxNum:
            maxNum = arr[i][j]; maxRow = i; maxCol = j

print(maxNum)
print(maxRow+1, maxCol+1)
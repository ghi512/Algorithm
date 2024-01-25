oldChess = list(map(int, input().split()))
chess = [1, 1, 2, 2, 2, 8]
print(*[a - b for a, b in zip(chess, oldChess)])
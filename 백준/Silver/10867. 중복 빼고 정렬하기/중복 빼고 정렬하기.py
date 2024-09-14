n = int(input())
arr = map(int, input().split())

result = []

for a in arr:
    if a in result:
        continue
    result.append(a)

result.sort()
print(*result)
n = int(input())
res = 1

while True:
    if n<=1:
        break
    n -= (6*res)
    res += 1

print(res)

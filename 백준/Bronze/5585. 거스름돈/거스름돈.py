pay = int(input())
amount = 1000 - pay
ans = 0

for m in [500, 100, 50, 10, 5, 1]:
    ans += amount//m
    amount %= m
print(ans)
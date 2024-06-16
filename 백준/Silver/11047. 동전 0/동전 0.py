n,k = map(int, input().split())
coins = []
for _ in range(n):
    coins.append(int(input()))
coins.reverse()

coin_num = 0
for coin in coins:
    if k>=coin:
        coin_num += (k//coin)
        k %= coin

print(coin_num)
n,m = map(int, input().split())
cards = list(map(int, input().split()))

max_sum = 0
for x in range(len(cards)-2):
    for y in range(x+1, len(cards)-1):
        for z in range(y+1, len(cards)):
            temp_sum = cards[x] + cards[y] + cards[z]
            if temp_sum > max_sum and temp_sum <= m:
                max_sum = temp_sum

print(max_sum)
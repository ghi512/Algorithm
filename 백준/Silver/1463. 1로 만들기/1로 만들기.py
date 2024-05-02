n = int(input())
dp = [0] * 1000001

# 가능한 연산 3가지
# 1. if x%3 == 0: x = x//3
# 2. if x%2 == 0: x = x//2
# 3. x -= 1

for i in range(2, n+1):
    dp[i] = dp[i-1] + 1 # 3번 연산

    if i%2 == 0: # 2번 연산
        dp[i] = min(dp[i], dp[i//2] + 1)
    if i%3 == 0: # 1번 연산
        dp[i] = min(dp[i], dp[i//3] + 1)

print(dp[n])
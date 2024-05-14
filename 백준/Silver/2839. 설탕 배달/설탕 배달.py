n = int(input())
dp = [-1] * 5001

dp[3], dp[5] = 1, 1
for i in range(6, n+1):
    if dp[i-3]<0 and dp[i-5]<0: # 구할 수 없는 경우 (0,1,2,4,7)
        dp[i] = -1
    elif dp[i-3]>0 and dp[i-5]>0: # 일반적인 경우
        dp[i] = min(dp[i-3], dp[i-5]) + 1
    else: # dp[i-3]또는 dp[i-5]의 값이 구할 수 없는 경우
        dp[i] = max(dp[i-3], dp[i-5]) + 1
 
print(dp[n])
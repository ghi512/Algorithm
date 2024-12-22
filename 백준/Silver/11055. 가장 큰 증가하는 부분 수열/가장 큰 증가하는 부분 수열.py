n = int(input())
num_list = list(map(int,input().split()))

dp = [1] * n
dp[0] = num_list[0]

for i in range(1,n):
    for j in range(i):
        if num_list[j] < num_list[i] :
            dp[i] = max(dp[i], dp[j]+num_list[i])
        else:
            dp[i] = max(dp[i], num_list[i])

print(max(dp))
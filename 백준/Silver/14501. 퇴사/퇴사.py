n = int(input())
times = []; values = []
for _ in range(n):
    t,v = map(int, input().split())
    times.append(t); values.append(v)

d = [0] * (n+1) # d[i] -> i번째 날부터 마지막 날까지의 최대 이익
max_value = 0

for i in range(n-1, -1, -1):
   temp = times[i] + i
   if temp <= n:
       d[i] = max(values[i]+d[temp], max_value)
       max_value = d[i]
   else: # 상담이 n을 넘어가는 경우
       d[i] = max_value

print(max_value)
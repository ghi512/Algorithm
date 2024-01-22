n = int(input())
nums = list(map(int, input().split()))
v = int(input())
answer = 0
for i in range(n):
    if(nums[i] == v):
        answer += 1
print(answer)
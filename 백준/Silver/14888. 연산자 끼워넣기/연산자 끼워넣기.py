n = int(input())
nums = list(map(int, input().split()))
ops = list(map(int, input().split())) # 차례대로 [덧셈,뺄셈,곱셈,나눗셈]

min_num = 1e9 # 10억
max_num = -1e9

def dfs(i, calc):
    global ops, min_num, max_num
    if i == n: # n개의 수를 모두 사용했을 때
        max_num = max(max_num, calc)
        min_num = min(min_num, calc)
        return

    if ops[0] > 0: # 덧셈
        ops[0] -= 1
        dfs(i+1, calc + nums[i])
        ops[0] += 1

    if ops[1] > 0:  # 뺄셈
        ops[1] -= 1
        dfs(i + 1, calc - nums[i])
        ops[1] += 1

    if ops[2] > 0:  # 곱셈
        ops[2] -= 1
        dfs(i + 1, calc * nums[i])
        ops[2] += 1

    if ops[3] > 0:  # 나눗셈
        ops[3] -= 1
        dfs(i + 1, int(calc / nums[i]))
        ops[3] += 1


dfs(1, nums[0])
print(int(max_num))
print(int(min_num))
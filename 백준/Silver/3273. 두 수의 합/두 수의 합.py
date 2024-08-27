import sys
input = sys.stdin.readline

arr_len = int(input())
arr = sorted(list(map(int, input().split())))
x = int(input())

res = 0
left, right = 0, arr_len-1

while left < right:
    temp = arr[left] + arr[right]
    if temp == x:
        res += 1
        left += 1
    elif temp < x:
        left += 1
    else:
        right -= 1

print(res)
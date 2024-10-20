import sys
input = sys.stdin.readline

n = int(input())
stack = []

for _ in range(n):
    arr = input().split()
    if arr[0] == '1':
        stack.append(int(arr[1]))
    elif arr[0] == '2':
        if stack:
            print(stack.pop(-1))
            continue
        print(-1)
    elif arr[0] == '3':
        print(len(stack))
    elif arr[0] == '4':
        if stack:
            print(0)
            continue
        print(1)
    elif arr[0] == '5':
        if stack:
            print(stack[-1])
            continue
        print(-1)

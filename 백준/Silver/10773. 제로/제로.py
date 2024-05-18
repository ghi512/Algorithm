import sys

k = int(sys.stdin.readline().rstrip())
stack = []

for _ in range(k):
    n = int(sys.stdin.readline().rstrip())
    if n == 0:
        stack.pop()
    else:
        stack.append(n)

if len(stack) > 0:
    print(sum(stack))
else:
    print(0)
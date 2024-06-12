from collections import deque
import sys

n = int(sys.stdin.readline())
inp = []
dq = deque()

for i in range(n):
    inp.append(list(sys.stdin.readline().rstrip().split()))
    if inp[i][0] == 'push_front':
        dq.appendleft(int(inp[i][1]))
    elif inp[i][0] == 'push_back':
        dq.append(int(inp[i][1]))
    elif inp[i][0] == 'size':
        print(len(dq))
    elif inp[i][0] == 'empty':
        if len(dq)==0:
            print(1)
        else:
            print(0)
    elif len(dq)==0:
        print(-1)
    elif inp[i][0] == 'pop_front':
        print(dq.popleft())
    elif inp[i][0] == 'pop_back':
        print(dq.pop())
    elif inp[i][0] == 'front':
        print(dq[0])
    elif inp[i][0] == 'back':
        print(dq[-1])


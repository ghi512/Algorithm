from collections import deque

n = int(input())
dq = deque()
for i in range(n):
    dq.append(i+1)

while len(dq) > 1:
    dq.popleft()
    bottom_card = dq.popleft()
    dq.append(bottom_card)

print(dq.pop())

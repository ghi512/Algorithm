import sys
input = sys.stdin.readline

S = input().strip()
x = input().strip()
i = 0
cnt = 0
while i < len(S):
    if S[i:i+len(x)] == x:
        i += len(x)
        cnt += 1
    else :
        i += 1
print(cnt)
n = int(input())
res = n

for _ in range(n):
    s = input()
    for i in range(0, len(s)-1):
        if s[i] == s[i+1]:
            pass
        elif s[i] in s[i+1:]:
            res -= 1
            break

print(res)
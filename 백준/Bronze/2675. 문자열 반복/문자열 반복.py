t = int(input())
for _ in range(t):
    n,s = input().split()
    n = int(n)
    for i in range(len(s)):
        print(s[i] * n, end='')
    print()
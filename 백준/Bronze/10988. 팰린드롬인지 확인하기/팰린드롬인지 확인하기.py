s = input()
res = 1
for i in range(len(s)//2):
    if(s[i] != s[-1-i]):
        res = 0
        break
print(res)
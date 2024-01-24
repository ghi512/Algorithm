s = input()
res = 0
for i in s:
    if(i==" "): res += 1
if(s[0]==" "): res -= 1
if(s[-1]==" "): res -= 1
print(res+1)
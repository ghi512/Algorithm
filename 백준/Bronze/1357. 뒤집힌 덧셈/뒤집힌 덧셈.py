a,b = input().split()
a = int(a[::-1])
b = int(b[::-1])

res = int(str(a+b)[::-1])
print(res)

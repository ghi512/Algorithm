li = [0] * 42
for _ in range(10):
    x = int(input())
    li[x%42] += 1

num = 0
for i in range(42):
    if(li[i] > 0):
        num += 1
print(num)
li = [1]*30
for _ in range(28):
    x = int(input())
    li[x-1] = 0

for i in range(30):
    if(li[i]==1):
        print(i+1)
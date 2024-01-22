maxNum = -1
index = -1
for i in range(1, 10):
    x = int(input())
    if(x > maxNum):
        maxNum = x; index=i
print(maxNum, index, sep='\n')
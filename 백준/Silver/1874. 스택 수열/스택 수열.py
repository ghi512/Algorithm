import sys
n = int(sys.stdin.readline())

stack = [1]
numlist = []
for i in range(n, 1, -1):
    numlist.append(i)

result = []
for i in range(n):
    result.append(int(sys.stdin.readline()))

index = 0
flag = 0
answer = ["+"]
while index < n:
    if len(stack)==0 and len(numlist)>0:
        stack.append(numlist.pop())
        answer.append("+")

    if result[index] == stack[-1]:
        stack.pop()
        answer.append("-")
        index += 1
    elif len(numlist) == 0:
        flag = 1
        break
    else:
        stack.append(numlist.pop())
        answer.append("+")
    
if flag == 1:
    print("NO")
else:
    for i in answer:
        print(i)
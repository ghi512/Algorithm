import sys
T = int(sys.stdin.readline())
answers = []

for i in range(T):
    str = input()
    stack = []
    flag = 0
    for s in str:
        if s=='(':
            stack.append('(')
        elif len(stack) > 0:
            stack.pop()
        else:
            flag = 1
            break

    if len(stack) > 0 or flag==1:
        answers.append("NO")
    else:
        answers.append("YES")

for anw in answers:
    print(anw)


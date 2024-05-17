import sys

irons = sys.stdin.readline().strip()
stack = []
answer = 0
pre_char = ''

for i in irons:
    if i=='(':
        stack.append('(')
        pre_char = '('
    elif pre_char == '(':
        stack.pop()
        answer += len(stack)
        pre_char = ')'
    else:
        stack.pop()
        answer += 1
        pre_char = ')'

print(answer)
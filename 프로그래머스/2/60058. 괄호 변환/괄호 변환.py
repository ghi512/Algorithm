# 균형 잡힌 괄호 문자열 -> (와 )의 개수가 같은지 확인
def isBalance(p):
    return p.count('(') == p.count(')')

# 올바른 괄호 문자열 -> (와 )의 짝이 맞는지 확인
def isCorrect(p):
    stack = []
    for i in p:
        if i == '(':
            stack.append('(')
        elif len(stack) == 0:
            return False
        else:
            stack.pop()
    return True

# 괄호 바꾸기
def swap(p):
    swaped_p = ""
    p = p[1:-1]
    for i in p:
        swaped_p += '(' if i == ')' else ')'
    return swaped_p

def dfs(p):
    if p == "":
        return p

    answer = ""
    u, v = p, ""
    for i in range(1, len(p)+1):
        if isBalance(p[:i]):
            u = p[:i]
            v = p[i:]
            break

    if isCorrect(u):
        answer = u + dfs(v)
    else:
        answer += '('
        answer += dfs(v)
        answer += ')'
        answer += swap(u)

    return answer

def solution(p):
    return dfs(p)
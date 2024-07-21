def solution(s):
    
    if s[0]=='+':
        s = int(s[1:len(s)])
    elif s[0]=='-':
        s = int(s[1:len(s)])
        s = -s
    else:
        s = int(s)
    
    return s
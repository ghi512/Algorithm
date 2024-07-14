def solution(s):
    s = list(s.lower())
    num_p, num_y = 0, 0
    for k in s:
        if k=='p':
            num_p += 1
        elif k=='y':
            num_y += 1
    if num_p != num_y:
        return False
    else:
        return True
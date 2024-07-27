def solution(n):
    arr = list(map(int, str(n)))
    arr.sort(reverse=True)
    print(arr)
    
    answer = ''
    for s in arr:
        answer += str(s)
    
    return int(answer)

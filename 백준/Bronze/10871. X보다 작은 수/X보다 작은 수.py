n,x = map(int, input().split())
a = list(map(int, input().split()))
answer = []
for i in range(n):
    if(a[i] < x):
        answer.append(a[i])
for k in range(len(answer)):
    print(answer[k], end=' ')
t = int(input())
btn = [300, 60, 10]
if t % 10 > 0:
    print(-1)
else:
    li = []
    for i in range(len(btn)):
        li.append(t // btn[i])
        t -= btn[i] * li[i]
    for i in li:
        print(i, end=' ')
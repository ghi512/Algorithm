li = input().split('-')
for i in range(len(li)):
    if li[i].find('+'):
        temp = map(int, li[i].split('+'))
        li[i] = sum(temp)

ans = li[0]
for i in range(1, len(li)):
    ans -= li[i]

print(ans)
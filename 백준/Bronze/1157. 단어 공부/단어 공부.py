inp = list(input())
alp = [0]*26
for s in inp:
    if(ord(s)>=97): alp[ord(s)-97] += 1
    else: alp[ord(s)-65] += 1
res = alp.index(max(alp))
for i in range(len(alp)):
    if(alp[i]==max(alp) and i != res):
        res = -2
        break
print(chr(res+65))
s = input()
res = 0
for i in s:
    if('A'<=i<='C'): res += 3
    elif('D'<=i<='F'): res += 4
    elif('G'<=i<='I'): res += 5
    elif('J'<=i<='L'): res += 6
    elif('M'<=i<='O'): res += 7
    elif('P'<=i<='S'): res += 8
    elif('T'<=i<='V'): res += 9
    elif('W'<=i<='Z'): res += 10
    else: continue
print(res)
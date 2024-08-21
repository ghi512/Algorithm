dwarfs = [0] * 9
for i in range(9):
    dwarfs[i] = int(input())
dwarfs.sort()

for x in range(0, 9):
    for y in range(x, 9):
        if (dwarfs[x] + dwarfs[y]) == (sum(dwarfs) - 100):
            dwarfs.pop(y)
            dwarfs.pop(x)
            break
    if len(dwarfs) == 7:
        break

for d in dwarfs:
    print(d)
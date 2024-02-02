words = []
lengths = []
for _ in range(5):
    s = input()
    words.append(list(s))
    lengths.append(len(list(s)))

res = ''

for i in range(max(lengths)):
    for j in range(5):
        if lengths[j] == 0:
            continue
        else:
            res += words[j][i]
            lengths[j] -= 1

print(res)
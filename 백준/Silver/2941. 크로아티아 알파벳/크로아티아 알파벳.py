s = input()
croatia = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']
for c in croatia:
    s = s.replace(c, 'a')
print(len(s))
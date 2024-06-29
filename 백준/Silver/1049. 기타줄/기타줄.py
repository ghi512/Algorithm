import sys
n,m = map(int, sys.stdin.readline().split())

arr_of_packs = []
arr_of_each = []

for _ in range(m):
    a,b = map(int, sys.stdin.readline().split())
    arr_of_packs.append(a)
    arr_of_each.append(b)

min_packs = min(arr_of_packs)
min_each = min(arr_of_each)

quo = n//6
rem = n%6

if min_each*6 < min_packs:
    min_packs = min_each*6

if rem>0:
    print(min(min_packs*(quo+1), min_packs*quo + min_each*rem))
else:
    print(min_packs*quo)
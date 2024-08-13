n = int(input())
seats = input()

num_s = seats.count('S')
num_ll = seats.count('LL')

ans = num_s + num_ll
if num_ll == 0:
    print(ans)
else:
    print(ans+1)
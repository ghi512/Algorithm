h,m = input().split()
h = int(h); m = int(m)
plusTime = int(input())

m += plusTime
times = int(m/60)

if(times > 0):
    m -= (60 * times)
    h += times
if(h > 23):
    h -= 24

print(h, m)
i = 1
while True:
    l, p, v = map(int, input().split())
    if l==0:
        break
    days = l*(v//p)
    if l < (v%p):
        days += l
    else:
        days += v%p
    print(f"Case {i}: {days}" )
    i += 1
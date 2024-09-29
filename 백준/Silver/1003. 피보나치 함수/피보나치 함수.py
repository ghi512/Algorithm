t = int(input())
for _ in range(t):
    n = int(input())

    zero = [0] * (41)
    one = [0] * (41)
    
    zero[0], one[0] = 1, 0 # f(0)
    zero[1], one[1] = 0, 1 # f(1)

    for i in range(2, n+1):
        zero[i] = zero[i-1] + zero[i-2]
        one[i] = one[i-1] + one[i-2]

    print(zero[n], one[n])
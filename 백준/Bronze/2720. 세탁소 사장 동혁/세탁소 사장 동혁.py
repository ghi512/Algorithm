t = int(input())

for _ in range(t):
    change = int(input())
    q = change//25; change %= 25
    d = change//10; change %= 10
    n = change//5; change %= 5
    p = change//1
    print(q, d, n, p)

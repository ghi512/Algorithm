n = int(input())
a = list(map(int, input().split()))
a.sort()
b = list(map(int, input().split()))
b.sort()

sum = 0
for i in range(n):
    sum += (a[i] * b[n-i-1])

print(sum)
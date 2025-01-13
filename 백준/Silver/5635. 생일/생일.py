arr = []
for _ in range(int(input())):
    n, d, m, y = input().split()
    arr.append([n, int(d), int(m), int(y)])
arr.sort(key=lambda x:(x[3],x[2],x[1]))
print(arr[-1][0])
print(arr[0][0])
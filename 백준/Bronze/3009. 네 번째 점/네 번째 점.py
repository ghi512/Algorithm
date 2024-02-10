arr = []
for _ in range(3):
    arr.append(list(map(int, input().split())))

res_x, res_y = arr[0][0], arr[0][1]

if res_x == arr[1][0]:
    res_x = arr[2][0]
elif res_x == arr[2][0]:
    res_x = arr[1][0]

if res_y == arr[1][1]:
    res_y = arr[2][1]
elif res_y == arr[2][1]:
    res_y = arr[1][1]

print(res_x, res_y)

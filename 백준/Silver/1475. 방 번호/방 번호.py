num = list(map(int, input()))
arr = [0] * 9
for n in num:
    if n==6 or n==9:
        arr[6] += 1
    else:
        arr[n] += 1

if arr[6]%2==0:
    arr[6] //= 2
else:
    arr[6] = arr[6]//2 + 1

print(max(arr))
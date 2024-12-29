w_array = []
k_array = []

for i in range(20):
    if i<10:
        w_array.append(int(input()))
    else:
        k_array.append(int(input()))

w_array.sort()
k_array.sort()
print((w_array[-1] + w_array[-2] + w_array[-3]), (k_array[-1] + k_array[-2] + k_array[-3]))
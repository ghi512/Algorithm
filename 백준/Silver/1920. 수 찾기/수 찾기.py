def binary_search(x, arr):
    start = 0
    end = len(arr)-1

    while start <= end:
        mid = (start + end) // 2
        if arr[mid] == x:
            return 1
        elif arr[mid] < x:
            start = mid+1
        else:
            end = mid-1
    return 0

import sys
n = int(sys.stdin.readline().strip())
arrN = list(map(int, sys.stdin.readline().strip().split(' ')))
arrN.sort() # 이분 탐색을 위해 오름차 순 정렬

m = int(sys.stdin.readline().strip())
arrM = list(map(int, sys.stdin.readline().strip().split(' ')))

for i in arrM:
    print(binary_search(i, arrN))
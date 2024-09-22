import sys
input = sys.stdin.readline

def binary_search(arr, card):
    start = 0
    end = len(arr)-1
    while start <= end:
        mid = (start + end) // 2
        if arr[mid] == card:
            return 1
        elif arr[mid] < card:
            start = mid + 1
        else:
            end = mid - 1
    return 0

n = int(input())
sanggeun = sorted(list(map(int, input().split())))
m = int(input())
cards = list(map(int, input().split()))

result = []
for c in cards:
    result.append(binary_search(sanggeun, c))
print(*result)
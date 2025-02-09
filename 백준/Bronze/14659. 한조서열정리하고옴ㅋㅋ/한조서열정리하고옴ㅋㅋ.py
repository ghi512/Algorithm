import sys
input = sys.stdin.readline

N = int(input())
bongs = list(map(int,input().split()))
max_count = 0
h = 0
count = 0
for hanzo in bongs:
    if h < hanzo:
        count = 0
        h = hanzo
    else:
        count += 1
        if max_count < count:
            max_count=count
print(max_count)
import sys

# n명의 키, 몸무게 정보 입력받기
n = int(sys.stdin.readline())
physical_info = []
for _ in range(n):
    temp = list(map(int, sys.stdin.readline().strip().split(' ')))
    physical_info.append(temp)

# 덩치 등수 구하기
big_rank = []
for i in range(n):
    rank = 1
    for j in range(n):
        if i==j:
            continue
        if physical_info[i][0] < physical_info[j][0] and physical_info[i][1] < physical_info[j][1]:
            rank += 1
    big_rank.append(rank)

# 결과 출력
for k in big_rank:
    print(k, end=' ')
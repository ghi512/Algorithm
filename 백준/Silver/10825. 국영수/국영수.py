import sys
input = sys.stdin.readline

n = int(input())
students = []
for _ in range(n):
    temp = input().split()
    students.append([temp[0], int(temp[1]), int(temp[2]), int(temp[3])])

students.sort(key=lambda x:x[0]) # 학생 이름 사전 순으로 정렬 (오름차)
students.sort(key=lambda x:x[3], reverse=True) # 수학 감소하는 순서로 정렬
students.sort(key=lambda x:x[2]) # 영어 증가하는 순서로 정렬
students.sort(key=lambda x:x[1], reverse=True) # 국어 감소하는 순서로 정렬

for s in students:
    print(s[0])
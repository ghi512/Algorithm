from queue import Queue

# 변수 초기화
n,k = map(int, input().split())
q = Queue()
for i in range(n):
    q.put(i+1)
results = []

# 요세푸스 순열 구하기
while q.qsize() > 0:
    for _ in range(k-1):
        q.put(q.get())
    results.append(q.get())

# 정답 출력
print("<", end='')
for j in range(0, n-1):
    print(results[j], end=', ')
print(results[-1], end='>')
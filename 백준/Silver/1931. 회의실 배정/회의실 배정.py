import sys

meeting_times = []
n = int(sys.stdin.readline())
for i in range(n):
    meeting_times.append(list(map(int, sys.stdin.readline().split())))

meeting_times.sort(key=lambda x: (x[1], x[0]))
meeting_num = 0
previous_time = 0

for m in meeting_times:
    if m[0] >= previous_time:
        meeting_num += 1
        previous_time = m[1]

print(meeting_num)
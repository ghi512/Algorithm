x,y = map(int, input().split())

days = 0
months = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
week = ['SUN', 'MON', 'TUE', 'WED', 'THU', 'FRI', 'SAT']

for i in range(x-1):
    days += months[i]
days += y

print(week[days%7])
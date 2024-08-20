n = int(input())
milks = map(int, input().split())

max_milk_num = 0
milk_type = 0
for m in milks:
    if m == (milk_type%3):
        max_milk_num += 1
        milk_type += 1

print(max_milk_num)
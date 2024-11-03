import sys
input = sys.stdin.readline

vowels = ['a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U']

while True:
    cnt = 0
    sentence = input()
    if sentence[0] == '#':
        break
    for s in sentence:
        if s in vowels:
            cnt += 1
    print(cnt)
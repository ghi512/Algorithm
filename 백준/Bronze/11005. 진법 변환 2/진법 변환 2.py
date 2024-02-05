import string
import sys
input = sys.stdin.readline

tmp = string.digits+string.ascii_uppercase
def convert(num, base) :
    q, r = divmod(num, base)
    if q == 0 :
        return tmp[r] 
    else :
        return convert(q, base) + tmp[r]

num,base = map(int, input().split()) # num: 10진법 수, base: 변환하려는 진법수
print(convert(num,base))
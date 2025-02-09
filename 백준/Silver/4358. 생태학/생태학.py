import sys
input = sys.stdin.readline
dic = {}
sum_tree = 0

while True:
    text = input().rstrip()
    if not text:
        break

    if text in dic:
        dic[text] += 1
    else:
        dic[text] = 1
    sum_tree += 1

sorted_tree = sorted(dic.keys())
for tree in sorted_tree:
    print("%s %.4f" % (tree, (dic[tree] / sum_tree) * 100))
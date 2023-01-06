import sys

n = int(sys.stdin.readline())
m = int(sys.stdin.readline())

lst = sorted(list(map(int, sys.stdin.readline().split())))

dic = dict()

cnt = 1
for i in range(len(lst)-1):
    if lst[i] != lst[i+1]:
        dic[lst[i]] = cnt
    else:
        cnt += 1
dic[lst[-1]] = cnt

result = 0
for num in lst:
    if num != m-num and m-num in dic.keys():
        if dic[m-num] != 0:
            dic[m-num] -= 1
            dic[num] -= 1
            result += 1
print(result)
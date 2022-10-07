import sys

n, k = map(int, sys.stdin.readline().split())

a_i = []
for i in range(n):
    a_i.append(int(sys.stdin.readline()))
tmp = k
cnt = 0
for i in range(len(a_i)-1, -1, -1):
    if tmp >= a_i[i]:
        cnt += tmp // a_i[i]
        tmp = tmp % a_i[i]
    if tmp == 0:
        print(cnt)
        break

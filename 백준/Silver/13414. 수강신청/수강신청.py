import sys

k, l = map(int, sys.stdin.readline().split())

lst = {}
cnt = 0
for _ in range(l):
    s_n = sys.stdin.readline()[:8]
    lst[s_n] = cnt
    cnt += 1

lst = sorted(lst.items(), key = lambda x: x[1])

for j in range(min(k, len(lst))):
    print(lst[j][0])

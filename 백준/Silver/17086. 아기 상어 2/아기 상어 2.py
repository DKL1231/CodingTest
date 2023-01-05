import sys

n, m = map(int, sys.stdin.readline().split())

shark = []
sea = []

for i in range(n):
    tmp = list(map(int, sys.stdin.readline().split()))
    sea.append(tmp)
    for j in range(m):
        if tmp[j] == 1:
            shark.append((i, j))

result = 0
for i in range(n):
    for j in range(m):
        if sea[i][j] == 0:
            tmp = n+m
            for k in range(len(shark)):
                sx, sy = shark[k]
                tmp = min(tmp, max(abs(sx-i), abs(sy-j)))
            result = max(tmp, result)

print(result)
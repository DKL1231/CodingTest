import sys

n = int(sys.stdin.readline())

m = 10001  # max + 1


lst = [0] * m
for i in range(n):
    lst[int(sys.stdin.readline())] += 1

for i in range(m):
    for j in range(lst[i]):
        print(i)

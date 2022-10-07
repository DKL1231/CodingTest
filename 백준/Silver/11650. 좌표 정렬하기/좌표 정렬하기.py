import sys
n = int(sys.stdin.readline())

lst = []
for i in range(n):
    lst.append(list(map(int, sys.stdin.readline().split())))

lst.sort()
for i in lst:
    print(i[0], i[1])

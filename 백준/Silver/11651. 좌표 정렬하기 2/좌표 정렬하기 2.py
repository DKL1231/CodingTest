import sys
n = int(sys.stdin.readline())

lst = []
for i in range(n):
    x = list(map(int, sys.stdin.readline().split()))
    lst.append([x[1], x[0]])

lst.sort()
for i in lst:
    print(i[1], i[0])

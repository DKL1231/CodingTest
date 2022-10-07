import sys

n, m = map(int, sys.stdin.readline().split())
a = []
for i in range(n):
    a.append(list(map(int, sys.stdin.readline().split())))

m, k = map(int, sys.stdin.readline().split())
b = []
for i in range(m):
    b.append(list(map(int, sys.stdin.readline().split())))
temp = 0
for i in range(n):
    for q in range(k):
        temp = 0
        for j in range(m):
            temp += a[i][j] * b[j][q]
        print(temp, end=' ')
    print()

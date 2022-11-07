import sys

n, m = map(int, sys.stdin.readline().split())

lp = 0
rp = m-1
temp = 0
pay = list(map(int, sys.stdin.readline().split()))

for i in range(m):
    temp += pay[i]
result = temp

for j in range(n-m):
    temp -= pay[lp]
    lp += 1
    rp += 1
    temp += pay[rp]
    result = max(temp, result)

print(result)
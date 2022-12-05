import sys

n, t = map(int, sys.stdin.readline().split())

lst = list(map(int,sys.stdin.readline().split()))

s = 0
result = n

for i in range(n):
    s += lst[i]
    if s > t:
        result = i
        break

print(result)
import sys

t = list(map(int, sys.stdin.readline().split()))
s = 0
for i in t:
    s += i*i
print(s % 10)
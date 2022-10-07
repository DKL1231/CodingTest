import sys

a, b = map(int, sys.stdin.readline().split())
c = int(sys.stdin.readline())

b += c
while b >= 60:
    b -= 60
    a += 1

if a > 23:
    print(a-24, b)
else:
    print(a, b)

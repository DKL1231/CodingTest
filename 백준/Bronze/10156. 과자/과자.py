import sys

a, b, c = map(int, sys.stdin.readline().split())

if a*b-c < 0:
    print(0)
else:
    print(a*b-c)
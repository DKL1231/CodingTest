import sys

a = int(sys.stdin.readline())
t = sys.stdin.readline()[:-1]
b = int(sys.stdin.readline())

if t == '+':
    print(a+b)
else:
    print(a*b)
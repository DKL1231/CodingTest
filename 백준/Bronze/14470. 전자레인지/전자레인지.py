import sys

a = int(sys.stdin.readline())
b = int(sys.stdin.readline())
c = int(sys.stdin.readline())
d = int(sys.stdin.readline())
e = int(sys.stdin.readline())
result = 0
if a < 0:
    result += -a * c
    result += d
    result += e * b
else:
    result = e * (b-a)

print(result)
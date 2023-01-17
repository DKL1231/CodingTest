import sys

n = int(sys.stdin.readline())
l = 0
r = 0
tmp = 0
result = 0
while l <= r:
    if tmp == n:
        result += 1
        r += 1
        tmp += r
    elif tmp > n:
        tmp -= l
        l += 1
    else:
        r += 1
        tmp += r
print(result)
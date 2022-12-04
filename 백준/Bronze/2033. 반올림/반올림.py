import sys

n = int(sys.stdin.readline())

tmp = 10
while n > tmp:
    mod = n%tmp
    if mod >= 5*tmp//10:
        n += tmp-mod
    else:
        n -= mod
    tmp *= 10

print(n)
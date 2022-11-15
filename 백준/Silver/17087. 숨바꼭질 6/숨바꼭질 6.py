import sys
import math

n, s = map(int, sys.stdin.readline().split())
lst = list(map(int, sys.stdin.readline().split()))

a = []
for i in range(n):
    a.append(abs(lst[i]-s))

a.sort()
result = a[n-1]

for i in range(1, n):
    result = math.gcd(result, a[n-1-i])

print(result)
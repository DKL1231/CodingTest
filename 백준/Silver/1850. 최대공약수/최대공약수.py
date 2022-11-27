import sys
import math
a, b = map(int, sys.stdin.readline().split())

c = math.gcd(a, b)

for i in range(c):
    print(1, end="")
print()

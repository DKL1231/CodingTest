import sys
import math

x, y = map(int, sys.stdin.readline().split())

print(math.gcd(x, y))
print(math.lcm(x, y))
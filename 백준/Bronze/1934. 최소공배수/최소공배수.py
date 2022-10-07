import sys
import math
t = int(sys.stdin.readline())
for i in range(t):
    a, b = map(int, sys.stdin.readline().split())
    c = math.gcd(a, b)
    print(a * b // c)

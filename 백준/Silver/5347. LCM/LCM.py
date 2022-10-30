import sys
import math

n = int(sys.stdin.readline())

for i in range(n):
    a, b = map(int, sys.stdin.readline().split())
    gcd = math.gcd(a, b)

    print(int(a * b / gcd))
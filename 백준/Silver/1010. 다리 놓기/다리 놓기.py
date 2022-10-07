import sys
import math

t = int(sys.stdin.readline())

for _ in range(t):
    n, m = map(int, sys.stdin.readline().split())
    print(math.factorial(m)//(math.factorial(n)*math.factorial(m-n)))

import sys
import math
n = int(sys.stdin.readline())

ring = list(map(int, sys.stdin.readline().split()))

for i in range(1, len(ring)):
    temp = math.gcd(ring[0], ring[i])
    print(f'{ring[0] // temp}/{ring[i] // temp}')

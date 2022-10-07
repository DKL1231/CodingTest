import sys
from collections import deque

n = int(sys.stdin.readline())

shake = [1, 1, 2]

for i in range(3, n+1):
    shake.append((shake[i-1]+shake[i-2]) % 10)

print(shake[n])
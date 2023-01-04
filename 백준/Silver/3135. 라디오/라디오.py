import sys
import math

a, b = map(int, sys.stdin.readline().split())
if a == b:
    print(0)
    exit()

lst = []

lst.append(abs(a-b))
lst.append(abs(b-a))

n = int(sys.stdin.readline())
for i in range(n):
    k = int(sys.stdin.readline())
    lst.append(abs(k-b)+1)   
    lst.append(abs(b-k)+1)

print(min(lst))
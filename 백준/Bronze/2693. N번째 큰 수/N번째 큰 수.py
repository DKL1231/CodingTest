import sys

t = int(sys.stdin.readline())

for _ in range(t):
    lst = list(map(int, sys.stdin.readline().split()))
    lst.sort()
    print(lst[-3])
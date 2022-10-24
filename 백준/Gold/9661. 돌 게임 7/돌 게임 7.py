import sys

n = int(sys.stdin.readline())

tmp = n % 5

if tmp in [0, 2]:
    print("CY")
else:
    print("SK")
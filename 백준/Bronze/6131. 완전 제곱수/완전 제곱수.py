import sys

n = int(sys.stdin.readline())

result = 0
b = 0
for i in range(1, 501):
    while i**2 - b**2 > n:
        b += 1
        if i**2 - b**2 == n:
            result += 1

print(result)
import sys
from itertools import combinations
n, l, r, x = map(int, sys.stdin.readline().split())

arr = list(map(int, input().split()))

result = 0
for i in range(2, n+1):
    comb = list(combinations(arr, i))
    for j in comb:
        if (l <= sum(j) <= r) and (x <= max(j)-min(j)):
            result += 1

print(result)
import sys
import math
n, m = map(int, sys.stdin.readline().split())

lst = []

for i in range(m):
    lst.append(int(sys.stdin.readline()))

left, right = 1, max(lst)
result = max(lst)
while left <= right:
    cnt = 0
    mid = (left + right) // 2
    for i in range(len(lst)):
        cnt += math.ceil(lst[i]/mid)
    if cnt > n:
        left = mid + 1
    else:
        result = min(result, mid)
        right = mid - 1
print(result)
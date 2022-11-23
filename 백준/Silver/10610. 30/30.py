import sys

s = sys.stdin.readline()[:-1]

lst = list(map(int,s))
lst.sort()
if sum(lst) % 3 == 0 and 0 in lst:
    for i in range(len(lst)):
        print(lst[len(lst)-i-1], end='')
    print()
else:
    print(-1)
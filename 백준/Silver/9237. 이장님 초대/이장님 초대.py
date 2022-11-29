import sys

n = int(sys.stdin.readline())

lst = list(map(int, sys.stdin.readline().split()))

lst.sort(reverse=True)

for i in range(len(lst)):
    lst[i] = lst[i]+i+1

print(max(lst)+1)
    
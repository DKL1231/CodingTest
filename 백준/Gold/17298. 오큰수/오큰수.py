import sys

p = int(sys.stdin.readline())
lst = list(map(int, sys.stdin.readline().split()))
nge = [-1] * p
index = [0]
for i in range(1, p):
    while len(index) != 0 and lst[index[-1]] < lst[i]:
        nge[index.pop()] = lst[i]
    index.append(i)

print(*nge)

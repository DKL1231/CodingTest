import sys
mrt = {}
lst = []
n = int(sys.stdin.readline())
for i in range(n):
    s = sys.stdin.readline()[:-1]
    if s not in mrt:
        mrt[s] = 1
    else:
        mrt[s] += 1

for i in range(n-1):
    s = sys.stdin.readline()[:-1]
    mrt[s] -= 1
    if mrt[s] == 0:
        mrt.pop(s)

for key in mrt:
    print(key)
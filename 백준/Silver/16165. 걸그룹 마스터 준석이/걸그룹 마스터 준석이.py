import sys

n, m = map(int, sys.stdin.readline().split())

data_g = {}
data_m = {}
for _ in range(n):
    group = sys.stdin.readline()[:-1]
    
    data_g[group] = []
    cnt = int(sys.stdin.readline())
    for i in range(cnt):
        member = sys.stdin.readline()[:-1]
        data_g[group].append(member)
        data_m[member] = group

for _ in range(m):
    quiz = sys.stdin.readline()[:-1]
    tp = int(sys.stdin.readline())
    
    if tp == 1:
        print(data_m[quiz])
    else:
        for mem in sorted(data_g[quiz]):
            print(mem)
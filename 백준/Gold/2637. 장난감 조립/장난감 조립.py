import sys
from collections import deque
# 2637
n = int(sys.stdin.readline())
m = int(sys.stdin.readline())

node = [[] for i in range(n+1)]
use = [[0] * (n+1) for i in range(n+1)]
level = [0] * (n+1)
q = deque()
for i in range(m):
    x, y, k = map(int, sys.stdin.readline().split())
    node[y].append([x, k])
    level[x] += 1

for i in range(1, n+1):
    if level[i] == 0:
        q.append(i)

while q:
    qf = q.popleft()
    for i in range(len(node[qf])):
        n_node = node[qf][i][0]
        cnt = node[qf][i][1]
        level[n_node] -= 1
        if sum(use[qf]) == 0:
            use[n_node][qf] += cnt
        else:
            for i in range(1, n+1):
                use[n_node][i] += use[qf][i] * cnt
        if level[n_node] == 0:
            q.append(n_node)

for i in range(len(use[n])):
    if use[n][i] != 0:
        print(i, use[n][i])

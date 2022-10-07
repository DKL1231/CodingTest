import sys
from collections import deque

n, m = map(int, sys.stdin.readline().split())
result = [0] * (n+1)
level = [0] * (n+1)
node = []
for i in range(n+1):
    node.append([])
for i in range(m):
    a, b = map(int, sys.stdin.readline().split())
    node[a].append(b)
    level[b] += 1


q = deque()

for i in range(1, n+1):
    if level[i] == 0:
        result[i] = 1
        q.append(i)

while q:
    now = q.popleft()
    for i in range(len(node[now])):
        n_node = node[now][i]
        level[n_node] -= 1
        if level[n_node] == 0:
            result[n_node] = result[now] + 1
            q.append(n_node)

for i in range(1, n+1):
    print(result[i], end=" ")
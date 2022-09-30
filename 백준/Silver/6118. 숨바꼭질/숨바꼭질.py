import sys
from collections import deque

n, m = map(int, sys.stdin.readline().split())
road = [[] for i in range(n+1)]
visit = [-1] * (n+1)

for i in range(m):
    a, b = map(int, sys.stdin.readline().split())
    road[a].append(b)
    road[b].append(a)

q = deque()
q.append(1)
visit[1] = 0

while q:
    now = q.popleft()
    for j in range(len(road[now])):
        nxt = road[now][j]
        if visit[nxt] == -1:
            visit[nxt] = visit[now] + 1
            q.append(nxt)
result = max(visit)
print(visit.index(result), result, visit.count(result))
import sys
from collections import deque

n, m, r = map(int, sys.stdin.readline().split())

visit = [0] * (n+1)
connect = [[] for i in range(n+1)]

for i in range(m):
    a, b = map(int, sys.stdin.readline().split())
    connect[a].append(b)
    connect[b].append(a)

q = deque()
q.append(r)
cnt = 1
visit[r] = cnt
while q:
    qf = q.popleft()
    for nxt in sorted(connect[qf]):
        if visit[nxt] == 0:
            visit[nxt] = cnt+1
            cnt += 1
            q.append(nxt)
for i in range(1, n+1):
    print(visit[i])
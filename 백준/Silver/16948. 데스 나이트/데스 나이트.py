import sys
from collections import deque

n = int(sys.stdin.readline())
r1, c1, r2, c2 = map(int, sys.stdin.readline().split())

dx = [[-2, -1], [-2, 1], [0, -2], [0, 2], [2, -1], [2, 1]]

result = 0

visit = []

for i in range(len(visit)):
    for j in range(len(visit[i])):
        print(visit[i][j], end=" ")
    print()

q = deque()

q.append((r1, c1))
visit.append((r1, c1))
while q:
    qs = len(q)
    for i in range(qs):
        qf = q.popleft()
        for j in range(len(dx)):
            nx = qf[0]+dx[j][0]
            ny = qf[1]+dx[j][1]
            if 0<=nx<n and 0<=ny<n and (nx, ny) not in visit:
                if nx == r2 and ny == c2:
                    print(result+1)
                    exit()
                visit.append((nx, ny))
                q.append((nx, ny))
    result+=1

print(-1)
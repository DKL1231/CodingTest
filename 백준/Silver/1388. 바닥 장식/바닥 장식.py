import sys
from collections import deque

n, m = map(int, sys.stdin.readline().split())
tile = []
for i in range(n):
    tile.append(list(sys.stdin.readline()[:-1]))
visit = [[False for i in range(m)] for j in range(n)]

cnt = 0
for i in range(n):
    for j in range(m):
        if not visit[i][j]:
            visit[i][j] = True
            t_type = False
            if tile[i][j] == '-':
                t_type = True
            q = deque()
            q.append((i, j))
            
            while q:
                qf = q.popleft()
                if t_type:
                    nx = qf[0]
                    ny = qf[1]+1
                    if nx < n and ny < m and not visit[nx][ny]:
                        if tile[nx][ny] == '-':
                            q.append((nx, ny))
                            visit[nx][ny] = True
                else:
                    nx = qf[0]+1
                    ny = qf[1]
                    if nx < n and ny< m and not visit[nx][ny]:
                        if tile[nx][ny] == '|':
                            q.append((nx, ny))
                            visit[nx][ny] = True
            cnt += 1

print(cnt)
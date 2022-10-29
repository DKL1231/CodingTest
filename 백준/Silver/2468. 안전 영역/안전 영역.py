import sys
from collections import deque

result = 1

n = int(sys.stdin.readline())
land = []
for i in range(n):
    land.append(list(map(int, sys.stdin.readline().split())))

mv = [[1, 0], [-1, 0], [0, -1], [0, 1]]
for hei in range(101):
    q = deque()
    visit = [[False for i in range(n)] for j in range(n)]
    cnt = 0
    for i in range(n):
        for j in range(n):
            if (not visit[i][j]) and (land[i][j] > hei):
                cnt += 1
                q.append((i, j))
                visit[i][j] = True
                while q:
                    qf = q.popleft()
                    for k in range(4):
                        nx = qf[0] + mv[k][0]
                        ny = qf[1] + mv[k][1]
                        if nx < 0 or nx >= n or ny < 0 or ny >= n:
                            continue
                        #print(f'from {qf[0], qf[1]} to {nx, ny} and land {land[nx][ny]} hei {hei} and visit {visit[nx][ny]}')
                        if (not visit[nx][ny]) and (land[nx][ny] > hei):
                            visit[nx][ny] = True
                            q.append((nx, ny))
    if result < cnt:
        result = cnt
    if cnt == 0:
        break
print(result)
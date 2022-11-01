import sys
from collections import deque

r, c = map(int, sys.stdin.readline().split())

yard = []
visit = [[False for i in range(c)] for j in range(r)]
for i in range(r):
    inp = list(sys.stdin.readline()[:-1])
    yard.append(inp)
mv = [[-1, 0], [1, 0], [0, -1], [0, 1]]
ans_s = 0
ans_w = 0
for i in range(r):
    for j in range(c):
        if yard[i][j] != '#' and not visit[i][j]:
            sheep = 0
            wolf = 0
            q = deque()
            q.append([i, j])
            visit[i][j] = True
            if yard[i][j] == 'o':
                sheep += 1
            elif yard[i][j] == 'v':
                wolf += 1
            while q:
                qf = q.popleft()
                for k in range(4):
                    nx = qf[0] + mv[k][0]
                    ny = qf[1] + mv[k][1]
                    if nx < 0 or nx >= r or ny < 0 or ny >= c:
                        continue
                    if not (visit[nx][ny] or yard[nx][ny] == '#'):
                        q.append([nx, ny])
                        visit[nx][ny] = True
                        if yard[nx][ny] == 'o':
                            sheep += 1
                        elif yard[nx][ny] == 'v':
                            wolf += 1
            if wolf < sheep:
                ans_s += sheep
            else:
                ans_w += wolf
print(ans_s, ans_w)
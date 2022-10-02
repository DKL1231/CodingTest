import sys
from collections import deque

r, c = map(int, sys.stdin.readline().split())
result_sheep = 0
result_wolf = 0
m = []
move = [[1, 0], [-1, 0], [0, 1], [0, -1]]
visit = [[False] * c for i in range(r)]
for i in range(r):
    m.append(input())

for i in range(r):
    for j in range(c):
        if m[i][j] != '#' and not visit[i][j]:
            tmp_sheep = 0
            tmp_wolf = 0
            q = deque()
            visit[i][j] = True
            q.append((i, j))
            while q:
                x, y = q.popleft()
                if m[x][y] == 'v':
                    tmp_wolf += 1
                elif m[x][y] == 'k':
                    tmp_sheep += 1
                for k in range(4):
                    nx = x + move[k][0]
                    ny = y + move[k][1]
                    if nx < 0 or nx >= r or ny < 0 or ny >= c or m[nx][ny] == '#':
                        continue
                    if not visit[nx][ny]:
                        q.append((nx, ny))
                        visit[nx][ny] = True
            if tmp_wolf < tmp_sheep:
                result_sheep += tmp_sheep
            else:
                result_wolf += tmp_wolf

print(result_sheep, result_wolf)

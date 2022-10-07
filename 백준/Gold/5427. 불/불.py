import sys
from collections import deque

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]


def fire(n):
    for j in range(n):
        x, y = fq.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= h or ny < 0 or ny >= w or building[nx][ny] == -1:
                continue
            if building[nx][ny] == 0:
                building[nx][ny] = building[x][y] + 1
                fq.append((nx, ny))


t = int(sys.stdin.readline())
for _ in range(t):
    w, h = map(int, sys.stdin.readline().split())

    q = deque()
    fq = deque()
    visit = [[0] * w for _ in range(h)]
    building = [[0] * w for _ in range(h)]
    for i in range(h):
        temp = sys.stdin.readline()
        for j in range(w):
            if temp[j] == '#':
                building[i][j] = -1
            elif temp[j] == '*':
                building[i][j] = 1
                fq.append((i, j))
            elif temp[j] == '.':
                building[i][j] = 0
            else:
                building[i][j] = 0
                start = (i, j)

    fire(len(fq))
    q.append(start)
    visit[start[0]][start[1]] = 1
    success = False
    result = 0
    while q and not success:
        qs = len(q)
        # for i in range(h):
        #     for j in range(w):
        #         print(visit[i][j], end="")
        #     print()
        # print()
        while qs:
            x, y = q.popleft()
            if x == 0 or x == h-1 or y == 0 or y == w-1:
                success = True
                result = visit[x][y]
                break
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if nx < 0 or nx >= h or ny < 0 or ny >= w or building[nx][ny] == -1:
                    continue
                if visit[nx][ny] == 0 and building[nx][ny] == 0:
                    visit[nx][ny] = visit[x][y] + 1
                    q.append((nx, ny))
            qs -= 1
        fire(len(fq))
    if success:
        print(result)
    else:
        print("IMPOSSIBLE")

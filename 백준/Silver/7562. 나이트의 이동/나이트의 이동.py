import sys
from collections import deque
mv = [(-2, 1),(-2, -1),(2, 1),(2, -1),(1, 2),(1, -2),(-1, 2),(-1, -2)]


t = int(sys.stdin.readline())

for _ in range(t):
    l = int(sys.stdin.readline())

    board = [[False] * l for i in range(l)]

    st_x, st_y = map(int, sys.stdin.readline().split())
    goal_x, goal_y = map(int, sys.stdin.readline().split())
    if st_x == goal_x and st_y == goal_y:
        print(0)
        continue
    q = deque()

    board[st_x][st_y] = True
    q.append((st_x, st_y))
    result = 0
    end = False
    while q:
        qs = len(q)
        for useless in range(qs):
            nowx, nowy = q.popleft()
            for i in range(len(mv)):
                nx = nowx+mv[i][0]
                ny = nowy+mv[i][1]
                if nx >= l or ny >= l or nx < 0 or ny < 0:
                    continue
                if not board[nx][ny]:
                    q.append((nx, ny))
                    board[nx][ny] = True
                    if nx == goal_x and ny == goal_y:
                        print(result+1)
                        end = True
                        break
            if end:
                break
        if end:
            break
        result += 1


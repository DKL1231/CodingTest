import sys
result = 987654321
mv = [[-1, 0], [1, 0], [0, -1], [0, 1]]


def can_plant(x, y):
    for i in range(4):
        nx = x + mv[i][0]
        ny = y + mv[i][1]
        if nx<0 or nx>=n or ny<0 or ny>=n:
            return False
        if visit[nx][ny]:
            return False
    return True


def dfs(cnt, now_money):
    global result
    if cnt == 3:
        result = min(result, now_money)
        return
    for i in range(n):
        for j in range(n):
            if (not visit[i][j]) and can_plant(i, j):
                visit[i][j] = True
                now_money += land[i][j]
                for k in range(4):
                    nx = i + mv[k][0]
                    ny = j + mv[k][1]
                    visit[nx][ny] = True
                    now_money += land[nx][ny]
                dfs(cnt+1, now_money)
                for k in range(4):
                    nx = i + mv[k][0]
                    ny = j + mv[k][1]
                    visit[nx][ny] = False
                    now_money -= land[nx][ny]
                visit[i][j] = False
                now_money -= land[i][j]


n = int(sys.stdin.readline())
land = []
visit = [[False] * n for i in range(n)]
for i in range(n):
    temp = list(map(int, sys.stdin.readline().split()))
    land.append(temp)

dfs(0, 0)
print(result)
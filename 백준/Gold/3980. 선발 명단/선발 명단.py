import sys
result = 0
s = 0


def dfs(n):
    global result, s
    if n == 11:
        result = max(result, s)
        return

    for i in range(11):
        if not visit[i]:
            if position[n][i] == 0:
                continue
            s += position[n][i]
            visit[i] = True
            dfs(n+1)
            visit[i] = False
            s -= position[n][i]


t = int(sys.stdin.readline())
for _ in range(t):
    visit = [False] * 11
    position = []
    for i in range(11):
        temp = list(map(int, sys.stdin.readline().split()))
        position.append(temp)
    dfs(0)
    print(result)
    result = 0
    s = 0

import sys


def dfs(deep, now):
    global result, end
    if deep == 5:
        result = 1
        end = True
        return

    for i in range(len(friend[now])):
        if end:
            return
        if not visit[friend[now][i]]:
            visit[friend[now][i]] = True
            dfs(deep+1, friend[now][i])
            visit[friend[now][i]] = False


end = False
result = 0
n, m = map(int, sys.stdin.readline().split())

friend = [[] for i in range(n)]
visit = [False] * n
for i in range(m):
    a, b = map(int, sys.stdin.readline().split())
    friend[a].append(b)
    friend[b].append(a)

for i in range(n):
    if result == 0:
        visit[i] = True
        dfs(1, i)
        visit[i] = False
print(result)

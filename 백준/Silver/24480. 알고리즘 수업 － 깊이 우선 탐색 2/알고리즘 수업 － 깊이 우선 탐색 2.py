import sys
sys.setrecursionlimit(10**7)
cnt = 1


def dfs(r):
    global cnt
    visit[r] = True
    result[r] = cnt
    for i in sorted(node[r], reverse=True):
        if not visit[i]:
            cnt += 1
            dfs(i)


n, m, r = map(int, sys.stdin.readline().split())
visit = [False] * (n + 1)
node = [[] for i in range(n+1)]
result = [0] * (n+1)
for i in range(m):
    u, v = map(int, sys.stdin.readline().split())
    node[u].append(v)
    node[v].append(u)

dfs(r)
for i in range(1, n+1):
    print(result[i])
import sys
sys.setrecursionlimit(10**7)


def dfs(x):
    global cnt
    for nd in sorted(node[x]):
        if result[nd] == 0:
            cnt += 1
            result[nd] = cnt
            dfs(nd)


n, m, r = map(int, sys.stdin.readline().split())

node = [[] for i in range(n+1)]
visit = []
result = [0] * (n+1)
for i in range(m):
    u, v = map(int, sys.stdin.readline().split())
    node[v].append(u)
    node[u].append(v)
cnt = 1
result[r] = cnt
dfs(r)

for i in range(1, n+1):
    print(result[i])

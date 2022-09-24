import sys
sys.setrecursionlimit(10**6)
parent = []


def find_p(a):
    if parent[a] == a:
        return a
    parent[a] = find_p(parent[a])
    return parent[a]


def union_p(a, b):
    pa = find_p(a)
    pb = find_p(b)
    parent[pa] = pb


n, m = map(int, sys.stdin.readline().split())
for i in range(n+1):
    parent.append(i)

for i in range(m):
    t, a, b = map(int, sys.stdin.readline().split())
    if t == 0:
        union_p(a, b)
    else:
        if find_p(a) == find_p(b):
            print("YES")
        else:
            print("NO")
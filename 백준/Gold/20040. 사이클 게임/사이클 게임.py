import sys
sys.setrecursionlimit(10 ** 6)


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
result = 0
parent = [i for i in range(n)]

for i in range(1, m+1):
    a, b = map(int, sys.stdin.readline().split())

    if find_p(a) != find_p(b):
        union_p(a, b)
    else:
        result = i
        break
print(result)
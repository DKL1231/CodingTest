import sys
import math
parent = [-1]
pnt = [[-1, -1]]

def find_p(a):
    if parent[a] == a:
        return a
    parent[a] = find_p(parent[a])
    return parent[a]

def p_union(a, b):
    pa = find_p(a)
    pb = find_p(b)
    if pa != pb:
        parent[pb] = pa

n, m = map(int, sys.stdin.readline().split())

for _ in range(n):
    x, y = map(int, sys.stdin.readline().split())
    pnt.append([x, y])
    parent.append(_+1)

for _ in range(m):
    a, b = map(int, sys.stdin.readline().split())
    p_union(a, b)


graph = []
for i in range(1, n+1):
    for j in range(i+1, n+1):
        if find_p(i) != find_p(j):
            graph.append([math.sqrt(math.pow(pnt[i][0]-pnt[j][0], 2) + math.pow(pnt[i][1]-pnt[j][1], 2)), i, j])

graph.sort()

result = 0
for i in range(len(graph)):
    w, a, b = graph[i]
    if find_p(a) != find_p(b):
        result += w
        p_union(a, b)

print(format(result, ".2f"))
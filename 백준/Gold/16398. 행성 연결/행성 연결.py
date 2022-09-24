import sys
from queue import PriorityQueue
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


n = int(sys.stdin.readline())
for i in range(n):
    parent.append(i)

q = PriorityQueue()
for i in range(n):
    temp = list(map(int, sys.stdin.readline().split()))
    for j in range(n):
        if i <= j:
            continue
        q.put([temp[j], i, j])
result = 0
qs = q.qsize()
for i in range(qs):
    w, x, y = q.get()
    #print(w, x, y)
    if find_p(x) != find_p(y):
        result += w
        union_p(x, y)

print(result)

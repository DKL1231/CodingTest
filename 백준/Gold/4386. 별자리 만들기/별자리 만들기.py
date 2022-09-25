import sys
from queue import PriorityQueue
from math import *


def find_p(a):
    if parent[a] == a:
        return a
    parent[a] = find_p(parent[a])
    return parent[a]


def union_p(a, b):
    pa = find_p(a)
    pb = find_p(b)
    parent[pb] = pa


n = int(sys.stdin.readline())
parent = [i for i in range(n)]
star = []
q = PriorityQueue()
for i in range(n):
    star.append(list(map(float, sys.stdin.readline().split())))

for i in range(n):
    for j in range(i+1, n):
        now_s = star[i]
        next_s = star[j]
        q.put([sqrt(pow(now_s[0]-next_s[0], 2) + pow(now_s[1]-next_s[1], 2)), i, j])

qs = q.qsize()
result = 0
for i in range(qs):
    w, a, b = q.get()
    if find_p(a) != find_p(b):
        union_p(a, b)
        result += w
print(result)

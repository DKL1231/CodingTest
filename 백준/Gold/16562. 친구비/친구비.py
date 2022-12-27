import sys

def find_p(a):
    if parent[a] == a:
        return a
    else:
        parent[a] = find_p(parent[a])
        return parent[a]

def union_p(a, b):
    pa = find_p(a)
    pb = find_p(b)
    if money[pa-1] >= money[pb-1]:
        parent[pa] = parent[pb]
    else:
        parent[pb] = parent[pa]
    


n, m, k = map(int, sys.stdin.readline().split())
money = list(map(int, sys.stdin.readline().split()))

parent = [i for i in range(n+1)]
for i in range(m):
    a, b = map(int, sys.stdin.readline().split())
    union_p(a, b)

visit = []
total = 0
for i in range(1, n+1):
    p = find_p(i)
    if p not in visit:
        visit.append(p)
        total += money[p-1]

if total > k:
    print("Oh no")
else:
    print(total)
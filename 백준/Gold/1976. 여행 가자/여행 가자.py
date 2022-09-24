import sys
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
m = int(sys.stdin.readline())

for i in range(n+1):
    parent.append(i)

for i in range(n):
    temp = list(map(int, sys.stdin.readline().split()))
    for j in range(n):
        if temp[j] == 1:
            union_p(i+1, j+1)

travel = list(map(int, sys.stdin.readline().split()))
for i in range(len(travel)):
    if find_p(travel[i]) != find_p(travel[0]):
        print("NO")
        exit()
print("YES")
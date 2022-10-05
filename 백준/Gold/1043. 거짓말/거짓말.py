import sys


def find_p(a):
    if parent[a] == a:
        return a
    parent[a] = find_p(parent[a])
    return parent[a]


def union_p(a, b):
    pa = find_p(a)
    pb = find_p(b)

    parent[pb] = pa


n, m = map(int, sys.stdin.readline().split())
parent = [i for i in range(n+1)]

know_p = list(map(int, sys.stdin.readline().split()))
for i in range(1, know_p[0]):
    union_p(know_p[i], know_p[i+1])
know_p = know_p[1:]

party = []
for i in range(m):
    temp = list(map(int, sys.stdin.readline().split()))
    for j in range(1, temp[0]):
        union_p(temp[j], temp[j+1])
    temp = temp[1:]
    party.append(temp)


result = 0
for i in range(m):
    if len(know_p) != 0:
        if find_p(party[i][0]) == find_p(know_p[0]):
            continue
    result += 1
print(result)
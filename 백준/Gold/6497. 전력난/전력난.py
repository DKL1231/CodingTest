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
    parent[pb] = pa


while True:
    m, n = map(int, sys.stdin.readline().split())
    if m == 0 and n == 0:
        break
    arr = []
    for i in range(m):
        parent.append(i)
    result = 0
    for i in range(n):
        a, b, w = map(int, sys.stdin.readline().split())
        arr.append([w, a, b])
        result += w

    arr.sort()
    for i in range(len(arr)):
        nx = arr[i][1]
        ny = arr[i][2]
        if find_p(nx) != find_p(ny):
            union_p(nx, ny)
            result -= arr[i][0]
    print(result)
    parent.clear()
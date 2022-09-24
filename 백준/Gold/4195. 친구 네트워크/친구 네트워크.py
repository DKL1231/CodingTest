import sys


def find_p(a):
    if parent[a] == a:
        return a
    parent[a] = find_p(parent[a])
    return parent[a]


def union_p(a, b):
    pa = find_p(a)
    pb = find_p(b)
    parent[pa] = pb
    friend_cnt[pa] += friend_cnt[pb]
    friend_cnt[pb] = friend_cnt[pa]


t = int(sys.stdin.readline())
for _ in range(t):
    f = int(sys.stdin.readline())
    parent = dict()
    friend_cnt = dict()

    for i in range(f):
        a, b = map(str, sys.stdin.readline().split())

        if a not in parent:
            parent[a] = a
            friend_cnt[a] = 1
        if b not in parent:
            parent[b] = b
            friend_cnt[b] = 1
        if find_p(a) != find_p(b):
            #print(find_p(a), find_p(b))
            union_p(a, b)
        print(friend_cnt[find_p(a)])


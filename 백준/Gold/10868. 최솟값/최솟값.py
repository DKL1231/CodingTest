import sys
from math import *

sys.setrecursionlimit(10 ** 6)


def min_tree(node, start, end):
    if start == end:
        tree[node] = nums[start]
        return tree[node]

    mid = (start + end) // 2
    left = min_tree(node * 2, start, mid)
    right = min_tree(node * 2 + 1, mid + 1, end)
    tree[node] = min(left, right)
    return tree[node]


def query(node, start, end, left, right):
    if start > right or end < left:
        return 1e9+1

    if left <= start and end <= right:
        return tree[node]

    mid = (start + end) // 2
    r1 = query(node * 2, start, mid, left, right)
    r2 = query(node * 2 + 1, mid + 1, end, left, right)
    return min(r1, r2)


n, m = map(int, sys.stdin.readline().split())
h = int(ceil(log2(n)))
ts = int(pow(2, h + 1))
nums = []
tree = [0] * ts

for i in range(n):
    inp = int(sys.stdin.readline())
    nums.append(inp)

min_tree(1, 0, n - 1)

for i in range(m):
    a, b = map(int, sys.stdin.readline().split())
    print(query(1, 0, n - 1, a - 1, b - 1))

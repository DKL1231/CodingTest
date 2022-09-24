import sys
from math import *

sys.setrecursionlimit(10 ** 6)


def min_tree(node, start, end):
    if start == end:
        tree1[node] = nums[start]
        return tree1[node]

    mid = (start + end) // 2
    left = min_tree(node * 2, start, mid)
    right = min_tree(node * 2 + 1, mid + 1, end)
    tree1[node] = min(left, right)
    return tree1[node]


def max_tree(node, start, end):
    if start == end:
        tree2[node] = nums[start]
        return tree2[node]

    mid = (start + end) // 2
    left = max_tree(node * 2, start, mid)
    right = max_tree(node * 2 + 1, mid + 1, end)
    tree2[node] = max(left, right)
    return tree2[node]


def min_query(node, start, end, left, right):
    if start > right or end < left:
        return 1e9+1

    if left <= start and end <= right:
        return tree1[node]

    mid = (start + end) // 2
    r1 = min_query(node * 2, start, mid, left, right)
    r2 = min_query(node * 2 + 1, mid + 1, end, left, right)
    return min(r1, r2)


def max_query(node, start, end, left, right):
    if start > right or end < left:
        return -1

    if left <= start and end <= right:
        return tree2[node]

    mid = (start + end) // 2
    r1 = max_query(node * 2, start, mid, left, right)
    r2 = max_query(node * 2 + 1, mid + 1, end, left, right)
    return max(r1, r2)


n, m = map(int, sys.stdin.readline().split())
h = int(ceil(log2(n)))
ts = int(pow(2, h + 1))
nums = []
tree1 = [0] * ts
tree2 = [0] * ts

for i in range(n):
    inp = int(sys.stdin.readline())
    nums.append(inp)

min_tree(1, 0, n - 1)
max_tree(1, 0, n - 1)
for i in range(m):
    a, b = map(int, sys.stdin.readline().split())
    print(min_query(1, 0, n - 1, a - 1, b - 1), max_query(1, 0, n - 1, a - 1, b - 1))

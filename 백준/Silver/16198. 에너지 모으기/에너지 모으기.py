import sys


result = 0
def dfs(cnt, lst):
    global result
    if len(lst) == 2:
        result = max(result, cnt)
        return

    for i in range(1, len(lst)-1):
        cnt += lst[i-1] * lst[i+1]
        dfs(cnt, lst[:i]+lst[i+1:])
        cnt -= lst[i-1] * lst[i+1]


n = int(sys.stdin.readline())
lst = list(map(int, sys.stdin.readline().split()))
dfs(0, lst)

print(result)
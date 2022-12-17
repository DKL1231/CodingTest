import sys


def dfs(deep, tmp):
    if deep == m:
        for num in tmp:
            print(num, end=' ')
        print()
        return
    
    for num in selected_lst:
        before = tmp.copy()
        tmp.append(num)
        dfs(deep+1, tmp)
        tmp = before



n, m = map(int, sys.stdin.readline().split())
lst = sorted(list(map(int, sys.stdin.readline().split())))

selected_lst = []
for num in lst:
    if num not in selected_lst:
        selected_lst.append(num)

dfs(0, [])
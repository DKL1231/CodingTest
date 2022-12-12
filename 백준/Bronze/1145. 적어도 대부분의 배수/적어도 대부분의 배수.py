import sys
import math
def get_result():
    global result
    a, b, c = selected
    gcd = math.gcd(a, b)
    tmp = int(a*b/gcd)
    gcd = math.gcd(tmp, c)
    result = min(result, tmp*c//gcd)

def dfs(n, idx):
    global selected
    if n == 3:
        get_result()
        return
    
    for i in range(idx, len(lst)):
        bef = selected.copy()
        selected.append(lst[i])
        dfs(n+1, i+1)
        selected = bef.copy()

lst = list(map(int, sys.stdin.readline().split()))
result = 10**8
selected = []

dfs(0, 0)
print(result)

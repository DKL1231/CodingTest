import sys

n, m = map(int, sys.stdin.readline().split())

k = list(map(int, sys.stdin.readline().split()))

result = [False for i in range(n+1)]

for i in range(len(k)):
    tmp = 1
    while tmp*k[i] <= n:
        result[tmp*k[i]] = True
        tmp += 1

ans = 0
for i in range(len(result)):
    if result[i]:
        ans += i

print(ans)
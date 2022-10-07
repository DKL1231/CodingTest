import sys

n, k = map(int, sys.stdin.readline().split())

coin = []
for i in range(n):
    coin.append(int(sys.stdin.readline()))

coin.sort()

dp = [100000] * (k+1)
able = [False] * (k+1)
dp[0] = 0
able[0] = True
for i in range(n):
    for j in range(coin[i], k+1):
        if able[j-coin[i]]:
            dp[j] = min(dp[j], dp[j-coin[i]]+1)
            able[j] = True

if able[k]:
    print(dp[k])
else:
    print(-1)
import sys
mod = 10**9+7
n, m = map(int, sys.stdin.readline().split())

dp = [[0 for i in range(m+1)] for j in range(n+1)]

for i in range(1, n+1):
    for j in range(1, m+1):
        if i == 1 or j == 1:
            dp[i][j] = 1
            continue
        dp[i][j] = (dp[i-1][j] + dp[i][j-1] + dp[i-1][j-1]) % mod

print(dp[n][m])
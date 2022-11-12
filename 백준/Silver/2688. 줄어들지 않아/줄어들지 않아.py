import sys

t = int(sys.stdin.readline())

for _ in range(t):
    n = int(sys.stdin.readline())
    dp = [[0 for i in range(11)] for j in range(n)]
    for i in range(10):
        dp[0][i] = 1
    dp[0][10] = 10
    
    for i in range(1, n):
        tmp = 0
        for j in range(0, 10):
            if j == 0:
                dp[i][j] = dp[i-1][10]
                tmp += dp[i][j]
            else:
                dp[i][j] = dp[i][j-1] - dp[i-1][j-1]
                tmp += dp[i][j]
        dp[i][10] = tmp
    
    print(dp[n-1][10])
    
import sys
dp = [1] * 41

n = int(sys.stdin.readline())

for i in range(3, n+1):
    dp[i] = dp[i-1]+dp[i-2]
print(dp[n], n-2)
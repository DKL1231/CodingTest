import sys

n = int(sys.stdin.readline())

dp = [1, 0, 3]

for i in range(3, n+1):
    if i % 2 == 1:
        dp.append(0)
    else:
        dp.append(0)
        dp[i] = dp[i-2]*dp[i-(i-2)]
        for j in range(2, i//2):
            dp[i] += 2*dp[i-j*2]
        dp[i] += 2
print(dp[n])
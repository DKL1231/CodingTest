import sys

n = int(sys.stdin.readline())
dp = [0] * (n+1)
arr = []
for _ in range(n):
    arr.append(list(map(int, sys.stdin.readline().split())))

for i in range(n):
    next_task_d = arr[i][0]
    next_task_m = arr[i][1]
    for j in range(i+next_task_d, n+1):
        dp[j] = max(dp[i]+next_task_m, dp[j])

print(dp[n])
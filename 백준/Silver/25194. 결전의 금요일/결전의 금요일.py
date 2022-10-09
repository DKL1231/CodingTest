import sys

n = int(sys.stdin.readline())
a = list(map(int, sys.stdin.readline().split()))

a.sort()
dp = []
for work in a:
    if work%7 == 0:
        continue
    ds = len(dp)
    for i in range(ds):
        if (dp[i]+work)%7 not in dp:
            dp.append((dp[i]+work)%7)
    if work%7 not in dp:
        dp.append(work%7)

result = "NO"
for day in dp:
    if day == 4:
        result = "YES"
print(result)
import sys

n = int(sys.stdin.readline())

dp = [False] * (n+1)
if n >= 2:
    dp[2] = True

next = [-1, -3, -4]
for i in range(4, n+1):
    for j in range(3):
        if i+next[j] >= 0:
            if not dp[i+next[j]]:
                dp[i] = True
                break
if dp[n]:
    print("SK")
else:
    print("CY")

#print(dp)
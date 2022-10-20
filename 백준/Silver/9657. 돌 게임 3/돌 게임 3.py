import sys
n = int(sys.stdin.readline())
dp = [False] * (n+1)

next = [-1, -3, -4]
for i in range(1, n+1):
    start = i
    for j in range(3):
        nxt = i+next[j]
        if nxt >= 0:
            if not dp[nxt]:
                dp[i] = True
                break

if dp[n]:
    print("SK")
else:
    print("CY")

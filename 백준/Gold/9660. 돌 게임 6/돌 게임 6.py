import sys

n = int(sys.stdin.readline())
dp = [False] * 8
mv = [-1, -3, -4]
for i in range(1, 8):
    for j in range(3):
        if i + mv[j] >= 0 and not dp[i + mv[j]]:
            dp[i] = True
            break

tmp = n % 7

if dp[tmp]:
    print("SK")
else:
    print("CY")
import sys
from collections import Counter

n = int(sys.stdin.readline())

num = [0] * n
for i in range(n):
    num[i] = int(sys.stdin.readline())

num.sort()

# 산술
print(round(sum(num) / n))
# 중앙
print(num[n//2])
# 최빈
cnt = Counter(num).most_common(2)
if len(cnt) > 1 and cnt[1][1] == cnt[0][1]:
    print(cnt[1][0])
else:
    print(cnt[0][0])
# 범위
print(num[-1] - num[0])




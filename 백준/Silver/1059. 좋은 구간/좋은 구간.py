import sys

l = int(sys.stdin.readline())
s = list(map(int, sys.stdin.readline().split()))
n = int(sys.stdin.readline())
s.append(0)
s.sort()
result = 0
for i in range(len(s)-1):
    if s[i] == n:
        result = 0
        break
    if s[i] < n < s[i + 1]:
        result = (n - s[i]) * (s[i + 1] - n) - 1
        break
print(result)

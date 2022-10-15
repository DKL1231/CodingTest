import sys

s = input()

arr = [[0] * (len(s)) for i in range(26)]

arr[ord(s[0])-ord('a')][0] = 1
for i in range(1, len(s)):
    for j in range(26):
        arr[j][i] = arr[j][i-1]
    arr[ord(s[i])-ord('a')][i] += 1

q = int(sys.stdin.readline())

for i in range(q):
    c, l, r = sys.stdin.readline().split()
    l = int(l)
    r = int(r)
    if l == 0:
        print(arr[ord(c) - ord('a')][r])
    else:
        print(arr[ord(c)-ord('a')][r]-arr[ord(c)-ord('a')][l-1])

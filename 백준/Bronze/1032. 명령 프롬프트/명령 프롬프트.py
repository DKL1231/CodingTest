import sys

n = int(sys.stdin.readline())

s = []
for i in range(n):
    s.append(input())
result = ""
for i in range(len(s[0])):
    check = True
    for j in range(1,n):
        if s[j][i] != s[0][i]:
            check = False
            break
    if check:
        result += s[0][i]
    else:
        result += '?'
print(result)

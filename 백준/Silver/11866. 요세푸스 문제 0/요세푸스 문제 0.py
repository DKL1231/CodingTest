import sys

n, k = map(int, sys.stdin.readline().split())
q = []
result = []
for i in range(n):
    q.append(i+1)
front = 0
while len(q) != 0:
    for i in range(k-1):
        q.append(q.pop(0))
    result.append(q.pop(0))

print("<", end="")
for i in range(len(result)-1):
    print(result[i], end=", ")
print(result[-1], end=">")
import sys

n = int(sys.stdin.readline())
rope = []
for i in range(n):
    rope.append(int(sys.stdin.readline()))

rope.sort()

result = 0
for i in range(n):
    result = max(result, rope[i]*(n-i))

print(result)
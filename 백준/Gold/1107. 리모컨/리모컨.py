import sys

n = int(sys.stdin.readline())
m = int(sys.stdin.readline())
broken = []
if m != 0:
    broken = list(map(int, sys.stdin.readline().split()))

result = abs(n-100)

for i in range(1000001):
    move = str(i)
    for j in range(len(move)):
        if int(move[j]) in broken:
            break
        if j == len(move)-1:
            result = min(result, abs(n-i)+j+1)

print(result)
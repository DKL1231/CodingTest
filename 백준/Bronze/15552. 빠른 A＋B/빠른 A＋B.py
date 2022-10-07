import sys
count = int(input())

result = []
for i in range(count):
    tmp = sys.stdin.readline().rstrip().split()
    result.append(int(tmp[0]) + int(tmp[1]))

for i in range(count):
    print(result[i])

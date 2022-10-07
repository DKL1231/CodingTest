import sys

n = int(sys.stdin.readline())

task = list(map(int, sys.stdin.readline().split()))

task.sort()
result = 0
for i in range(len(task)):
    for j in range(i+1):
        result += task[j]

print(result)

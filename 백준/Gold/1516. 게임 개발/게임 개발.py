import sys
from collections import deque

n = int(sys.stdin.readline())

building = []
to_build = []
for i in range(n+1):
    building.append([])
    to_build.append([])
build_time = [0] * (n+1)
level = [0] * (n+1)

for i in range(1, n+1):
    arr = list(map(int, sys.stdin.readline().split()))
    for j in range(len(arr)):
        if j == 0:
            build_time[i] = arr[j]
        else:
            if arr[j] == -1:
                break
            building[arr[j]].append(i)
            to_build[i].append(arr[j])
            level[i] += 1

q = deque()
result = [0] * (n+1)
for i in range(1, n+1):
    if level[i] == 0:
        q.append(i)
        result[i] = build_time[i]


while q:
    qf = q.popleft()
    for i in range(len(building[qf])):
        next_node = building[qf][i]
        level[next_node] -= 1
        if level[next_node] == 0:
            q.append(next_node)
            to_plus = 0
            for i in range(len(to_build[next_node])):
                to_plus = max(result[to_build[next_node][i]],to_plus)
            result[next_node] = build_time[next_node]+to_plus


for i in range(1, n+1):
    print(result[i])

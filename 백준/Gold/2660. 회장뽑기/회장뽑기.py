import sys
from collections import deque
n = int(input())

arr = [[] for i in range(n+1)]
result = []
while True:
    a, b = map(int, sys.stdin.readline().split())
    if a == -1 and b == -1:
        break
    arr[a].append(b)
    arr[b].append(a)

answer = n+1
for i in range(1,n+1):
    q = deque()
    q.append(i)
    visit = [False] * (n + 1)
    visit[i] = True
    level = -1
    while q:
        qs = len(q)
        for k in range(qs):
            qf = q.popleft()
#            print(qf)
            for j in range(len(arr[qf])):
                nxt = arr[qf][j]
                if not visit[nxt]:
                    q.append(nxt)
                    visit[nxt] = True
        level += 1
    result.append(level)
    answer = min(answer, level)
#    print("-------------")
cnt = 0
lst = []
for i in range(n):
    if result[i] == answer:
        cnt += 1
        lst.append(i+1)

print(answer, cnt)
for i in range(len(lst)):
    print(lst[i], end = " ")

import sys
from collections import deque

n, m = map(int, sys.stdin.readline().split())
node = [[] for i in range(n+1)]
visit = [False] * (n+1)
for i in range(m):
    u, v = map(int, sys.stdin.readline().split())
    node[u].append(v)

s = int(sys.stdin.readline())
fan = list(map(int, sys.stdin.readline().split()))
for i in range(s):
    visit[fan[i]] = True
q = deque()

result = "Yes"
if 1 in fan:
    print(result)
    exit()
q.append(1)
visit[1] = True

while q:
    qf = q.popleft()
    if len(node[qf]) == 0:
        result = "yes"
        break
    for next_node in node[qf]:
        if not visit[next_node]:
            q.append(next_node)
            visit[next_node] = True
print(result)
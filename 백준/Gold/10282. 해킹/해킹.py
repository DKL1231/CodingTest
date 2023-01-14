import sys
from queue import PriorityQueue
t = int(sys.stdin.readline())

for _ in range(t):
    n, d, c = map(int, sys.stdin.readline().split())
    comp = [[] for i in range(n+1)]
    for i in range(d):
        a, b, s = map(int, sys.stdin.readline().split())
        comp[b].append([s, b, a])
    q = PriorityQueue()
    
    visit = [False for i in range(n+1)]
    time_lst = [0 for i in range(n+1)]
    visit[c] = True
    cnt = 1
    for lst in comp[c]:
        q.put(lst)
    while q.qsize():
        w, f, t = q.get()
        if not visit[t]:
            cnt += 1
            visit[t] = True
            time_lst[t] = w
            for lst in comp[t]:
                new_lst = [lst[0]+time_lst[t], lst[1], lst[2]]
                q.put(new_lst)
    print(cnt, max(time_lst))
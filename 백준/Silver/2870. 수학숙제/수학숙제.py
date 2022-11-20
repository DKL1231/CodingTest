import sys
from queue import PriorityQueue

q = PriorityQueue()

n = int(sys.stdin.readline())

num = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']
for _ in range(n):
    s = sys.stdin.readline()[:-1]
    now_num = False
    tmp = 0
    
    for i in range(len(s)):
        if s[i] in num:
            now_num = True
            tmp = tmp*10 + int(s[i])
        elif now_num:
            now_num = False
            q.put(tmp)
            tmp = 0
    if now_num:
        q.put(tmp)

qs = q.qsize()
for i in range(qs):
    print(q.get())
import sys
from collections import deque

n = int(sys.stdin.readline())

q = deque([i for i in range(1, n+1)])

while q:
    try:
        print(q.popleft())
        q.append(q.popleft())
    except:
        break
    

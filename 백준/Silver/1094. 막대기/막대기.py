import sys
from queue import PriorityQueue

q = PriorityQueue()

n = int(sys.stdin.readline())
if n == 64:
    print(1)
    exit()
total = 64
q.put(total)
result = 1
while True:
    now = q.get()
    
    half = now/2
    if total-half >= n:
        total -= half
        q.put(half)
        if total == n:
            break
    else:
        q.put(half)
        q.put(half)
        result += 1

print(result)
import sys
from queue import PriorityQueue

while True:
    n = int(sys.stdin.readline())
    
    if n == 0:
        break
    
    dic = {}
    pq = PriorityQueue()
    for i in range(n):
        s = sys.stdin.readline()[:-1]
        s_low = s.lower()
        dic[s_low] = s
        pq.put(s_low)
    
    print(dic[pq.get()])
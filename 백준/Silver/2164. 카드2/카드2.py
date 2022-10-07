import sys

p = int(sys.stdin.readline())
q = []
for i in range(p):
    q.append(i+1)
front = 0
while len(q) != front+1:
    front += 2
    q.append(q[front-1])

print(q[front])
import sys
from collections import deque

buf = deque()
n = int(sys.stdin.readline())
while True:
    inp = int(sys.stdin.readline())
    if inp == -1:
        break
    elif inp == 0:
        buf.popleft()
        #print(buf)
    else:
        if len(buf) == n:
            #print(buf)
            continue
        else:
            buf.append(inp)
            #print(buf)
if len(buf) == 0:
    print("empty")
else:
    while buf:
        print(buf.popleft(), end=" ")
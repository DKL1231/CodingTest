import sys
import heapq

n = int(sys.stdin.readline())
solved = {}
hard = []
easy = []
for i in range(n):
    p, l = map(int, sys.stdin.readline().split())
    heapq.heappush(hard, (-l, -p))
    heapq.heappush(easy, (l, p))
    solved[p] = False

m = int(sys.stdin.readline())
for i in range(m):
    inp = sys.stdin.readline().split()
    if inp[0] == 'add':
        p, l = int(inp[1]), int(inp[2])
        while solved[-hard[0][1]]:
            heapq.heappop(hard)
        while solved[easy[0][1]]:
            heapq.heappop(easy)
        heapq.heappush(hard, (-l, -p))
        heapq.heappush(easy, (l, p))
        solved[p] = False
    elif inp[0] == 'recommend':
        cmd = int(inp[1])
        if cmd == 1:
            while solved[-hard[0][1]]:
                heapq.heappop(hard)
            print(-hard[0][1])
        else:
            while solved[easy[0][1]]:
                heapq.heappop(easy)
            print(easy[0][1])
    elif inp[0] == 'solved':
        p = int(inp[1])
        solved[p] = True

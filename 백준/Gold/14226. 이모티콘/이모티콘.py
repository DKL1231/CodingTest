from collections import deque

s = int(input())
n = 1

q = deque()
q.append([1, 0])
visit = dict()
visit[(1, 0)] = 0

while q:
    tmp = q.popleft()
    nx = tmp[0]
    clip = tmp[1]
    if nx == s:
        result = visit[(nx, clip)]
        break
    if (nx, nx) not in visit.keys():
        visit[(nx, nx)] = visit[(nx, clip)]+1
        q.append([nx, nx])
    if (nx+clip, clip) not in visit.keys():
        visit[(nx+clip, clip)] = visit[(nx, clip)] + 1
        q.append([nx+clip, clip])
    if (nx-1, clip) not in visit.keys():
        visit[(nx-1, clip)] = visit[(nx, clip)] + 1
        q.append([nx-1, clip])

print(result)

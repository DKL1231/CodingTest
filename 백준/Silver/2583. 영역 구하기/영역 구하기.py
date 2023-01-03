#2583
import sys
from collections import deque
m, n, k = map(int, sys.stdin.readline().split())

board = [[True for i in range(n)] for j in range(m)]
for _ in range(k):
    a, b, c, d = map(int, sys.stdin.readline().split())
    
    for i in range(b, d):
        for j in range(a, c):
            if board[i][j]:
                board[i][j] = False

result = []
mv = [(0, 1), (0, -1), (1, 0), (-1, 0)]

for i in range(m):
    for j in range(n):
        if board[i][j]:
            q = deque()
            area = 1
            q.append((i, j))
            board[i][j] = False
            
            while q:
                x, y = q.popleft()
                for j in range(4):
                    nx = x + mv[j][0]
                    ny = y + mv[j][1]
                    
                    if 0<=nx<m and 0<=ny<n and board[nx][ny]:
                        q.append((nx, ny))
                        board[nx][ny] = False
                        area += 1
            result.append(area)

print(len(result))
for area in sorted(result):
    print(area, end=" ")
print()
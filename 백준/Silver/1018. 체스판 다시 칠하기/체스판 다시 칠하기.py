import sys
n, m = map(int, sys.stdin.readline().split())

board = []
for i in range(n):
    board.append(sys.stdin.readline())

result = float("inf")
for i in range(n-7):
    for j in range(m-7):
        fst_black = 0
        fst_white = 0
        for k in range(i, i+8):
            for l in range(j, j+8):
                if (k+l) % 2 == 0:
                    if board[k][l] == 'W':
                        fst_black += 1
                    else:
                        fst_white += 1
                else:
                    if board[k][l] == 'W':
                        fst_white += 1
                    else:
                        fst_black += 1
        if result > fst_white:
            result = fst_white
        if result > fst_black:
            result = fst_black

print(result)
import sys

n = int(sys.stdin.readline())
field = []
for i in range(n):
    field.append(list(sys.stdin.readline()[:-1]))

result = [['*' for i in range(n)] for j in range(n)]
mv = [[1, 0], [0, 1], [-1, 0], [0, -1], [1, 1], [1, -1], [-1, 1], [-1, -1]]
for i in range(n):
    for j in range(n):
        if field[i][j] != '.':
            print(result[i][j], end='')
            continue
        result[i][j] = '0'
        for k in range(8):
            nx = mv[k][0]+i
            ny = mv[k][1]+j
            if nx < 0 or nx >= n or ny < 0 or ny >=n or field[nx][ny] == '.':
                continue
            result[i][j] = str(int(result[i][j]) + int(field[nx][ny]))
            if int(result[i][j]) >= 10:
                result[i][j] = 'M'
                break
        print(result[i][j], end='')
    print()

import sys


def get_result(row, col, ind):
    if ind == 1:
        return lst[row][col]

    tmp = ind//2
    result = [get_result(row, col, tmp), get_result(row+tmp, col, tmp), get_result(row, col+tmp, tmp), get_result(row+tmp, col+tmp, tmp)]
    result.sort()
    return result[2]


n = int(sys.stdin.readline())
lst = []
for i in range(n):
    lst.append(list(map(int, sys.stdin.readline().split())))

print(get_result(0, 0, n))
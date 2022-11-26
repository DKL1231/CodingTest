import sys

change = [-1 for i in range(100001)]
change[0] = 0

money = [2, 5]
for i in range(2, 100001):
    tmp = []
    for j in range(2):
        if i-money[j] < 0:
            continue
        if change[i-money[j]] == -1:
            continue
        tmp.append(change[i-money[j]]+1)
    if len(tmp) == 0:
        change[i] = -1
    else:
        change[i] = min(tmp)


n = int(sys.stdin.readline())

print(change[n])
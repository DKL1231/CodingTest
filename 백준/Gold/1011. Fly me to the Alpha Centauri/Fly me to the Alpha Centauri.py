inp = int(input())

for i in range(inp):
    x, y = map(int, input().split())
    way = y - x
    cnt = 0
    tmp = 1
    while way > 0:
        way -= tmp
        cnt += 1
        if cnt % 2 == 0:
            tmp += 1
    print(cnt)

for i in range(int(input())):
    x1, y1, r1, x2, y2, r2 = map(int, input().split())
    dis = ((x1-x2)**2+(y1-y2)**2)**0.5
    # 1개의 경우
    if dis == (r1 + r2) or dis == abs(r1 - r2):
        result = 1
    # 0개의 경우
    elif dis > (r1 + r2) or r1 > dis+r2 or r2 > dis+r1:
        result = 0
    # 2개의 경우
    else:
        result = 2
    # 무한개의 경우
    if x1 == x2 and y1 == y2 and r1 == r2:
        result = -1
    print(result)

import sys

n, c = map(int, sys.stdin.readline().split())
house = []
for i in range(n):
    house.append(int(sys.stdin.readline()))

house.sort()

l, r = 0, house[n-1]-house[0]
while l <= r:
    m = (l + r) // 2
    now = house[0]
    cnt = 1

    for i in range(1, n):
        if house[i] - now >= m:
            cnt += 1
            now = house[i]

    if cnt >= c:
        l = m + 1
    else:
        r = m - 1

print(r)
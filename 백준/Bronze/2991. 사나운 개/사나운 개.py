import sys

a, b, c, d = map(int, sys.stdin.readline().split())

people = list(map(int, sys.stdin.readline().split()))

for i in range(3):
    cnt = 0
    
    if 0 < people[i] % (a+b) <= a:
        cnt += 1
    if 0 < people[i] % (c+d) <= c:
        cnt += 1

    print(cnt)

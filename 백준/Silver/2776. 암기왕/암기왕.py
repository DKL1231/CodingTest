import sys

t = int(sys.stdin.readline())

for _ in range(t):
    n = int(sys.stdin.readline())
    l1 = list(map(int, sys.stdin.readline().split()))
    dic = {}
    for num in l1:
        dic[num] = 1
    m = map(int, sys.stdin.readline())
    l2 = list(map(int, sys.stdin.readline().split()))
    
    for num in l2:
        try:
            print(dic[num])
        except:
            print(0)
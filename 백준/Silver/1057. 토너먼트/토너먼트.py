import sys

n, k, l = map(int, sys.stdin.readline().split())

cnt = 1
while n != 1:
    if k%2 == 1:
        k += 1
    k //= 2
    
    if l%2 == 1:
        l += 1
    l //= 2
    
    if k == l:
        print(cnt)
        break
    if n%2 == 1:
        n += 1
    n //= 2
    cnt += 1
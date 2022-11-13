import sys

while True:
    try:
        n = int(input())
    except EOFError:
        break
    
    tmp = 1
    cnt = 1
    
    while tmp % n != 0:
        tmp *= 10
        tmp += 1
        cnt += 1
    print(cnt)
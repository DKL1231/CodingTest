import sys

for _ in range(3):
    n = int(sys.stdin.readline())
    tmp = 0
    for i in range(n):
        tmp += int(sys.stdin.readline())
    
    if tmp == 0:
        print('0')
    elif tmp > 0:
        print('+')
    else:
        print('-')
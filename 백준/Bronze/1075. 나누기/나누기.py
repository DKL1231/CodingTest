import sys

n = int(sys.stdin.readline())
f = int(sys.stdin.readline())
n = n//100*100

tmp = 0

while tmp <= 99:
    if (n + tmp) % f == 0:
        if tmp<10:
            print(0,end='')
        print(tmp)
        break
    tmp += 1
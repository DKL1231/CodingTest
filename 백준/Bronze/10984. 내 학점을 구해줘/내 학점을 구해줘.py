import sys

t = int(sys.stdin.readline())

for _ in range(t):
    n = int(sys.stdin.readline())
    
    score = 0
    time = 0
    for i in range(n):
        a, b = map(float, sys.stdin.readline().split())
        time += a
        score += a*b
    
    print(int(time), round(score/time, 1))
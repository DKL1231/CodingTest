import sys

n = int(sys.stdin.readline())

s_a = s_b = 100

for i in range(n):
    a, b = map(int,sys.stdin.readline().split())
    
    if a==b:
        continue
    elif a>b:
        s_b -= a
    else:
        s_a -= b
print(f'{s_a}\n{s_b}')
import sys

n = int(sys.stdin.readline())
s = list(sys.stdin.readline()[:-1])
a = 0
b = 0

for i in range(n):
    if s[i] == 'A':
        a += 1
    else:
        b += 1

if a>b:
    print("A")
elif a<b:
    print("B")
else:
    print("Tie")
import sys
import math
tmp = 0
while True:
    tmp += 1
    a, b, c = map(int, sys.stdin.readline().split())
    if a==b==c==0:
        break
    
    print(f"Triangle #{tmp}")
    if c != -1:
        if a >= c:
            print("Impossible.\n")
            continue
        if b >= c:
            print("Impossible.\n")
            continue
        if a == -1:
            print(f"a = {math.sqrt(c**2-b**2):.3f}\n")
            continue
        if b == -1:
            print(f"b = {math.sqrt(c**2-a**2):.3f}\n")
    else:
        print(f"c = {math.sqrt(a**2+b**2):.3f}\n")
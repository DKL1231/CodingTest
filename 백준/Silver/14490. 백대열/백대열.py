import sys
import math
s = sys.stdin.readline()[:-1]
tmp = s.find(':')
n = int(s[:tmp])
m = int(s[tmp+1:])

print(f'{int(n/math.gcd(n,m))}:{int(m/math.gcd(n,m))}')
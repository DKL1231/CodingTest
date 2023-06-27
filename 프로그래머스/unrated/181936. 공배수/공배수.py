import math
def solution(number, n, m):
    return int(not number%(n*m/math.gcd(n,m)))
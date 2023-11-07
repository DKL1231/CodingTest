def solution(n, m):
    import math
    return [math.gcd(n, m), n*m//math.gcd(n,m)]
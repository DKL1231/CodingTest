def solution(balls, share):
    import math
    return math.factorial(balls)//(math.factorial(share)*math.factorial(balls-share))
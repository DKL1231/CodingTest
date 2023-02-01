def solution(n):
    tmp = 1
    i = 1
    while tmp <= n:
        i += 1
        tmp *= i
    return i-1
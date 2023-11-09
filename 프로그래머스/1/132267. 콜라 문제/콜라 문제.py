def solution(a, b, n):
    answer = 0
    while n >= a:
        tmp = (n//a)*b
        n = (n//a)*b+n%a
        answer += tmp
    return answer
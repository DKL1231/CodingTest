def solution(x):
    num = 0
    tmp = x
    while tmp:
        num += tmp%10
        tmp //= 10
    return True if x%num == 0 else False
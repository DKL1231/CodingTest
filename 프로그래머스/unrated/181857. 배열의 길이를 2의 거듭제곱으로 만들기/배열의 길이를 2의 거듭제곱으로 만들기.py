def solution(arr):
    if len(arr) == 1:
        return arr
    tmp = 2
    while len(arr) > tmp:
        tmp *= 2
    return arr + [0] * (tmp-len(arr))
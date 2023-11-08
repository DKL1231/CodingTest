def solution(s):
    stk = [-1 for i in range(1000000)]
    idx = 0
    for i in list(s):
        if idx==0 or stk[idx-1] != i:
            stk[idx] = i
            idx += 1
        else:
            idx -= 1
    return 0 if idx else 1
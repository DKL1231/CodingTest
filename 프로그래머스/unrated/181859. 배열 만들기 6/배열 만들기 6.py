def solution(arr):
    stk = []
    for i, num in enumerate(arr):
        if not stk or stk[-1] != num:
            stk.append(num)
        else:
            stk = stk[:-1]
    return stk if stk else [-1]
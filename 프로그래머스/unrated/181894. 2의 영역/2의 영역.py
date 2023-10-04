def solution(arr):
    lp = -1
    rp = lp
    for i, num in enumerate(arr):
        if num == 2:
            if lp == -1:
                lp = i
                rp = i
            else:
                rp = i
    return arr[lp:rp+1] if lp != -1 else [-1]
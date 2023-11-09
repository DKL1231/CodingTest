def solution(array):
    array.sort()
    pf, pe = 0, -1
    prv = -1
    best, cnt = [], 1
    for i, num in enumerate(array):
        if prv != num:
            if cnt == pe-pf+1:
                best.append(prv)
            elif cnt < pe-pf+1:
                best = [prv]
                cnt = pe-pf+1
            pf = i
            pe = i
            prv = num
        else:
            pe = i
    if cnt == pe-pf+1:
        best.append(prv)
    elif cnt < pe-pf+1:
        best = [prv]
        cnt = pe-pf+1
    return best[0] if len(best) == 1 else -1
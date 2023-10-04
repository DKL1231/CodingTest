def solution(strArr):
    strArr.sort(key=lambda x : len(x))
    prv = -1
    cnt = 0
    answer = 0
    for s in strArr:
        if len(s) != prv:
            prv = len(s)
            answer = max(answer, cnt)
            cnt = 0
        cnt += 1
    return max(answer, cnt)
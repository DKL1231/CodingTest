def solution(s):
    answer = 0
    prv = 0
    s = list(s.split())
    for c in s:
        if c == 'Z':
            answer = prv
        else:
            prv = answer
            answer += int(c)
    return answer
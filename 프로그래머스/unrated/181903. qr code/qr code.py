def solution(q, r, code):
    answer = ''
    for i, s in enumerate(list(code)):
        if i%q==r:
            answer += s
    return answer
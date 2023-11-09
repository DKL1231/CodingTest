def solution(k, score):
    l_k = []
    answer = []
    for i, s in enumerate(score):
        if i >= k:
            l_k.append(s)
            l_k = sorted(l_k, reverse=True)[:-1]
        else:
            l_k.append(s)
            l_k = sorted(l_k, reverse=True)
        answer.append(l_k[-1])
    return answer
def solution(score):
    new_score = []
    for i, [e, m] in enumerate(score):
        new_score.append([e+m, i])
    new_score.sort(reverse=True)
    new_list = []
    rank = 1
    tmp = 1
    for i, [s, idx] in enumerate(new_score):
        new_list.append([rank, idx])
        if i+1 < len(new_score) and new_score[i+1][0]==s:
            tmp += 1
        else:
            rank += tmp
            tmp = 1
    answer = [rank for rank, idx in sorted(new_list, key=lambda x: x[1])]
    return answer
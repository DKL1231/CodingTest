def solution(quiz):
    answer = []
    for s in quiz:
        sf, se = s.split(" = ")
        if eval(sf) != int(se):
            answer.append("X")
        else:
            answer.append("O")
    return answer
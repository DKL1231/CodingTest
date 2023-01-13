def solution(dot):
    answer = 1
    if dot[0] < 0:
        answer += 1
    if dot[1] < 0:
        if answer == 1:
            answer += 2
        answer += 1
    return answer
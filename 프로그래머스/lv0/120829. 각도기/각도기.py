def solution(angle):
    answer = (angle // 90) * 2
    if angle % 90 != 0:
        answer += 1
    return answer
def solution(s1, s2):
    answer = 0
    for s in s1:
        for target in s2:
            if s == target:
                answer += 1
                break
    return answer
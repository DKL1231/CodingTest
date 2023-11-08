def solution(n):
    answer = 0
    count = 0
    while count < n:
        count += 1
        answer += 1
        if answer%3==0 or '3' in str(answer):
            count -= 1
    return answer
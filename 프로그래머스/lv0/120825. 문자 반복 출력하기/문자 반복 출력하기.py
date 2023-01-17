def solution(my_string, n):
    answer = ''
    for s in my_string:
        for i in range(n):
            answer += s
    return answer
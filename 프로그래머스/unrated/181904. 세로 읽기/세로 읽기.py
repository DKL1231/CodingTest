def solution(my_string, m, c):
    answer = ''
    while c-1 < len(my_string):
        answer += my_string[c-1]
        c += m
    return answer
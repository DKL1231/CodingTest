def solution(my_strings, parts):
    answer = ''
    for idx, s in enumerate(my_strings):
        answer += s[parts[idx][0]:parts[idx][1]+1]
    return answer
def solution(my_string):
    answer = ''
    for s in my_string:
        if 'a' <= s <= 'z':
            answer += s.upper()
        else:
            answer += s.lower()
    return answer
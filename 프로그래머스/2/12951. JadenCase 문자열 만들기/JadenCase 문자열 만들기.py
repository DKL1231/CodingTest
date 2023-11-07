def solution(s):
    answer = list(s.lower())
    for idx, i in enumerate(answer):
        if idx == 0:
            if 'a' <= i <= 'z':
                answer[idx] = i.upper()
        elif answer[idx-1] == " ":
            if 'a' <= i <= 'z':
                answer[idx] = i.upper()
    return "".join(answer)
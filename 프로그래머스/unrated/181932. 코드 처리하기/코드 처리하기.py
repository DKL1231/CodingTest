def solution(code):
    answer = ''
    mode = True
    for i, s in enumerate(list(code)):
        if s == '1':
            mode = not mode
        else:
            if mode:
                if not i%2:
                    answer += s
            else:
                if i%2:
                    answer += s
    return answer if answer else 'EMPTY'
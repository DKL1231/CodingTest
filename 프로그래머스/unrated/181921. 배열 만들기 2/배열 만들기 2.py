def solution(l, r):
    answer = []
    for i in range(l, r+1):
        if not "".join(("".join(str(i).split('5'))).split('0')):
            answer.append(i)
    return answer if len(answer) else [-1]
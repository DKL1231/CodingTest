def solution(numLog):
    answer = ''
    for i in range(len(numLog)-1):
        tmp = numLog[i+1]-numLog[i]
        if tmp == 1:
            answer += 'w'
        elif tmp == -1:
            answer += 's'
        elif tmp == 10:
            answer += 'd'
        else:
            answer += 'a'
    return answer
def solution(s):
    tmp = sorted(list(s))
    cnt = 1
    answer = ''
    for i in range(len(tmp)-1):
        if tmp[i] == tmp[i+1]:
            cnt += 1
        else:
            if cnt == 1:
                answer += tmp[i]
            cnt = 1
    if cnt == 1:
        answer += tmp[-1]
    return answer
def solution(myString, pat):
    answer = 0
    for idx, s in enumerate(list(myString)):
        if s == pat[0]:
            flag = True
            for p_idx, p_s in enumerate(list(pat)):
                if p_idx+idx>=len(myString) or p_s != myString[p_idx+idx]:
                    flag = False
                    break
            if flag:
                answer += 1
    return answer
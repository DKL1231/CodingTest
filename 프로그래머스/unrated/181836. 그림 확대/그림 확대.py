def solution(picture, k):
    answer = []
    for s in picture:
        tmp = "" 
        for i in s:
            tmp += i*k
        for i in range(k):
            answer.append(tmp)
    return answer
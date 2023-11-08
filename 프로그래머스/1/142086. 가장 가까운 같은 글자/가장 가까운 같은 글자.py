def solution(s):
    dic = {}
    answer = []
    for idx, string in enumerate(list(s)):
        if string in dic.keys():
            answer.append(idx+1-dic[string])
            dic[string] = idx+1
        else:
            dic[string] = idx+1
            answer.append(-1)
    return answer
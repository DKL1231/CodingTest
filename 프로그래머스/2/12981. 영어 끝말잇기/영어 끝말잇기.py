def solution(n, words):
    dic = {}
    prv = ''
    for i, s in enumerate(words):
        if i != 0:
            if prv[-1] != s[0]:
                return [i%n+1, i//n+1]
        if s in dic.keys():
            return [i%n+1, i//n+1]
        else:
            dic[s] = 0
        prv = s
    return [0,0]
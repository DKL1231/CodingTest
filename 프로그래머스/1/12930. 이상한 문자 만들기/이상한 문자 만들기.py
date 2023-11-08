def solution(s):
    lst = s.split(' ')
    answer = []
    for string in lst:
        l_s = list(string)
        for i, ss in enumerate(l_s):
            if not i%2:
                l_s[i] = ss.upper()
            else:
                l_s[i] = ss.lower()
        answer.append("".join(l_s))
    return " ".join(answer)
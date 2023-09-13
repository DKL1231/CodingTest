def solution(myString, pat):
    tmp = ''
    for s in pat:
        if s == "A":
            tmp += "B"
        elif s == "B":
            tmp += "A"
        else:
            tmp += s
    return 1 if tmp in myString else 0
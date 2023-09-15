def solution(myString):
    result = ''
    for s in myString:
        if s == 'A' or s == 'a':
            result += 'A'
        else:
            result += s.lower()
    return result
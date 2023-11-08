def solution(s, n):
    answer = ''
    for s in list(s):
        if s == ' ':
            answer += s
        else:
            if s.isupper():
                answer += chr((ord(s)+n-ord('A'))%26+ord('A'))
            else:
                answer += chr((ord(s)+n-ord('a'))%26+ord('a'))
    return answer
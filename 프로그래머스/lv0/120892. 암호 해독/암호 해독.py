def solution(cipher, code):
    return ''.join([cipher[i] for i in range(len(cipher)) if i%code==code-1])
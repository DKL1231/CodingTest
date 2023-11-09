def solution(n,a,b):
    tmp = n//2
    if a%2: a+=1
    if b%2: b+=1
    ta, tb = True if a<=tmp else False, True if b<=tmp else False
    answer = 1
    while a != b:
        a //= 2
        b //= 2
        if a%2: a+=1
        if b%2: b+=1
        ta, tb = True if a<=tmp else False, True if b<=tmp else False
        tmp //= 2
        answer += 1
    return answer
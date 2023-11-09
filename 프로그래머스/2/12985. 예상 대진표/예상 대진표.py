def solution(n,a,b):
    if a%2: a+=1
    if b%2: b+=1
    answer = 1
    while a != b:
        a //= 2
        b //= 2
        if a%2: a+=1
        if b%2: b+=1
        answer += 1
    return answer
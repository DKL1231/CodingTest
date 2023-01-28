def solution(age):
    answer = ''
    while age:
        answer += chr(ord('a') + age%10)
        age //= 10
    answer = answer[::-1]
    return answer
def solution(n):
    answer = 0
    for i in range(1, n+1):
        tmp = i
        for j in range(i+1, n+1):
            if tmp == n:
                answer += 1
                break
            if tmp > n:
                break
            tmp += j
    return answer+1
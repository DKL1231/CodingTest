def solution(n):
    prime = [1]
    num = [True for i in range(n+1)]
    for i in range(2, n+1):
        if num[i]:
            prime.append(i)
            tmp = 2
            while tmp*i <= n:
                num[tmp*i] = False
                tmp += 1
    return n-len(prime)
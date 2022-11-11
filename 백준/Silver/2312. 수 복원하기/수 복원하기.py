import sys

t = int(sys.stdin.readline())

prime = [True] * 400
prime[0] = prime[1] = False

for i in range(2, 400):
    if prime[i]:
        tmp = 2
        while tmp*i<400:
            prime[tmp*i] = False
            tmp += 1

for _ in range(t):
    n = int(sys.stdin.readline())
    tmp = n
    result = []
    for i in range(2, tmp+1):
        if tmp % i == 0:
            cnt = 0
            while tmp % i == 0:
                tmp /= i
                cnt += 1
            result.append((i, cnt))
    
    for i in range(len(result)):
        print(result[i][0], result[i][1])

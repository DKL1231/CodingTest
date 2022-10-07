import sys
t = int(sys.stdin.readline())

prime = [True] * 1000001
prime[0] = False
prime[1] = False
for i in range(2, 1000001):
    if prime[i]:
        temp = 2
        while True:
            if i*temp >= 1000000:
                break
            prime[i*temp] = False
            temp += 1


temp = 1
for _ in range(t):
    n = int(sys.stdin.readline())
    result = 1
    for i in range(2, n):
        if prime[i]:
            if prime[n-i]:
                result += 1
    print(result//2)

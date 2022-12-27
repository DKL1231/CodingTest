import sys

n, k = map(int, sys.stdin.readline().split())

prime = [True for i in range(n+1)]

prime[0] = prime[1] = False

cnt = 0
for i in range(2, n+1):
    if prime[i]:
        tmp = 1
        while tmp*i <= n:
            if prime[tmp*i]:
                cnt += 1
            prime[tmp*i] = False
            if cnt == k:
                print(tmp*i)
                break
            tmp += 1

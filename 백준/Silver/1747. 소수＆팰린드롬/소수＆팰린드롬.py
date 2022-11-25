import sys

prime = [True for i in range(1003002)]
p_s = 1003002
prime[0] = False
prime[1] = False
n = int(sys.stdin.readline())

for i in range(2, p_s):
    if prime[i]:
        tmp = 2
        while i*tmp < p_s:
            prime[i*tmp] = False
            tmp += 1

for i in range(n, p_s):
    if prime[i]:
        s_p = str(i)
        check = True
        for j in range(len(s_p)):
            if s_p[j] != s_p[-j-1]:
                check = False
                break
        if check:
            print(i)
            break
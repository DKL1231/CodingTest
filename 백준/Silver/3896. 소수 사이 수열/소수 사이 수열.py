import sys

prime = [True] * 1299710
prime[0] = False
prime[1] = False

for i in range(2, 1299710):
    if prime[i]:
        tmp = 2
        while i*tmp <=1299709:
            prime[i*tmp] = False
            tmp += 1

T = int(sys.stdin.readline())
for i in range(T):
    k = int(sys.stdin.readline())
    if prime[k]:
        print(0)
        continue
    lp = k-1
    rp = k+1
    while not prime[lp]:
        lp -= 1
    while not prime[rp]:
        rp += 1
    print(rp-lp)
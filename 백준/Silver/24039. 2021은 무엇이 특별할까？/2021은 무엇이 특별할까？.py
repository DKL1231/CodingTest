import sys

n = int(sys.stdin.readline())
prime = [True for i in range(110)]
prime[0] = prime[1] = False
for i in range(2, 110):
    if prime[i]:
        tmp = 2
        while tmp*i < 110:
            prime[tmp*i] = False
            tmp += 1

fst = 2
for i in range(3, 110):
    if prime[i]:
        scd = i
        if fst*scd > n:
            print(fst*scd)
            break
        fst = scd

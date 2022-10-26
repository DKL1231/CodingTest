import sys

t = int(sys.stdin.readline())

prime = [True] * 1001
prime[0] = False
prime[1] = False
cur = 2

for i in range(t):
    inp = int(sys.stdin.readline())

    while inp > cur:
        tmp = 2
        while tmp * cur <= 1000:
            prime[tmp * cur] = False
            tmp += 1
        cur += 1
    end = False
    for j in range(2, 1001):
        if j >= inp:
            break
        if end:
            break
        if prime[j]:
            num1 = j
            inp -= j
            for k in range(num1, 1001):
                if k > inp:
                    break
                if end:
                    break
                if prime[k]:
                    num2 = k
                    inp -= k
                    for l in range(num2, 1001):
                        if l > inp:
                            break
                        if l == inp and prime[l]:
                            print(num1, num2, l)
                            end = True
                            break
                    inp += k
            inp += j
    if not end:
        print(0)
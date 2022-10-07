def prime_num(x):
    if x < 2:
        return False
    for i in range(2, x//2+1):
        if x % i == 0:
            return False
    return True


m = int(input())
n = int(input())

total = 0
for j in range(n, m-1, -1):
    if prime_num(j):
        total += j
        small = j
if total == 0:
    print(-1)
else:
    print(total)
    print(small)

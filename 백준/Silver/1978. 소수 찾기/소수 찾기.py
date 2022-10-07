def prime_num(x):
    if x < 2:
        return False
    for n in range(2, x//2+1):
        if x % n == 0:
            return False
    return True


inp = int(input())

num = input().split()
cnt = 0
for i in range(inp):
    if prime_num(int(num[i])):
        cnt += 1

print(cnt)

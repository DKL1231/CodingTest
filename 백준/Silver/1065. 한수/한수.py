def is_han(n):
    front_num = n % 10
    n = int(n / 10)
    term = -10
    while n != 0:
        back_num = n % 10
        if term == -10:
            term = front_num - back_num
        elif term != front_num - back_num:
            return 0
        front_num = back_num
        n = int(n / 10)
    return 1


get = int(input())

cnt = 0

for i in range(1, get+1):
    cnt += is_han(i)
print(cnt)

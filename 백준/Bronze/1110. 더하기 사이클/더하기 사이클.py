n = int(input())
cnt = 0
if n < 10:
    n = '0' + str(n)
else:
    n = str(n)
front_num = int(n[0])
back_num = int(n[1])

while True:
    a = front_num+back_num
    if a >= 10:
        a = int(str(a)[1])
    result = 10*back_num + a
    cnt += 1
    if result == int(n):
        print(cnt)
        break
    front_num = back_num
    back_num = a

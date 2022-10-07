sugar = int(input())

cnt = 0
while True:
    if sugar % 5 == 0:
        cnt += sugar // 5
        break
    sugar -= 3
    cnt += 1
    if sugar < 0:
        cnt = -1
        break

print(cnt)

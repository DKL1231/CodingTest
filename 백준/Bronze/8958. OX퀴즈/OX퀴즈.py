cnt = int(input())

result = []

for i in range(cnt):
    get = input()
    scr = 0
    total = 0
    for j in range(len(get)):
        if get[j] == 'O':
            scr += 1
            total += scr
        else:
            scr = 0
    result.append(total)

for i in range(cnt):
    print(result[i])

cnt = int(input())

lst = []
for i in range(cnt):
    info = list(map(int, input().split()))
    avg = (sum(info)-info[0])/info[0]
    over_avg = 0
    for j in range(1, info[0]+1):
        if info[j] > avg:
            over_avg += 1
    lst.append(over_avg/info[0]*100)

for i in range(cnt):
    print(f'{lst[i]:.3f}%')

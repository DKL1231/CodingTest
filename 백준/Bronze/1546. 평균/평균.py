cnt = int(input())

scr = list(map(int, input().split()))

total = 0
for i in range(cnt):
    total += scr[i]/max(scr)*100

print(total/len(scr))

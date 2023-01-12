import sys

day = [0]
n, x = map(int, sys.stdin.readline().split())

today = list(map(int, sys.stdin.readline().split()))

for i in range(len(today)):
    day.append(today[i]+day[len(day)-1])

result = 0
cnt = 0
for i in range(x, n+1):
    if result == day[i]-day[i-x]:
        cnt += 1
    elif result < day[i]-day[i-x]:
        result = day[i]-day[i-x]
        cnt = 1

if result == 0:
    print("SAD")
else:
    print(result)
    print(cnt)
import sys

n = int(sys.stdin.readline())
confer = []
for i in range(n):
    confer.append(list(map(int, sys.stdin.readline().split())))

# 끝 시간으로 우선 정렬 후 시작 시간으로 또 정렬
confer.sort(key=lambda x: (x[1], x[0]))
count = 0
end_time = -1
result = []
for i in range(n):
    # 새로운 회의를 추가할 수 있을 때 갱신
    if end_time <= confer[i][0]:
        end_time = confer[i][1]
        count += 1
        result.append(confer[i])
print(count)

count = int(input())

a = []
b = []
for i in range(count):
    tmp1, tmp2 = map(int, input().split())
    a.append(tmp1)
    b.append(tmp2)

for i in range(count):
    print(a[i] + b[i])

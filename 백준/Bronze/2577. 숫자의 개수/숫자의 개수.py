a = int(input())
b = int(input())
c = int(input())

result = str(a*b*c)
lst = [0 for i in range(10)]

for i in range(len(result)):
    lst[int(result[i])] += 1

for i in range(10):
    print(lst[i])

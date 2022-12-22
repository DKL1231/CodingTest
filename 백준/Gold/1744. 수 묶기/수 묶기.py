import sys

n = int(sys.stdin.readline())

lst = []
lst_m = []
for _ in range(n):
    tmp = int(sys.stdin.readline())
    if tmp > 0:
        lst.append(tmp)
    else:
        lst_m.append(tmp)

lst.sort(reverse=True)
lst_m.sort()

result = 0
combine = False
for i in range(len(lst)):
    if combine:
        combine = False
    else:
        combine = True
        if lst[i] == 1 or i == len(lst) - 1 or lst[i+1] == 1:
            result += lst[i]
            combine = False
        else:
            result += lst[i]*lst[i+1]

combine = False
for i in range(len(lst_m)):
    if combine:
        combine = False
    else:
        combine = True
        if i == len(lst_m) - 1:
            result += lst_m[i]
        else:
            result += lst_m[i]*lst_m[i+1]

print(result)
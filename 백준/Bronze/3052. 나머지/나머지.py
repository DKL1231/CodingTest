lst = []
for i in range(10):
    a = int(input())
    a = a % 42
    check = 1
    for j in range(len(lst)):
        if lst[j] == a:
            check = 0
            break
    if check == 1:
        lst.append(a)

print(len(lst))

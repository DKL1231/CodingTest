lst = []
for i in range(9):
    lst.append(int(input()))

max_n = lst[0]
max_cnt = 1
for i in range(8):
    if max_n < lst[i+1]:
        max_n = lst[i+1]
        max_cnt = i+2

print(max_n)
print(max_cnt)

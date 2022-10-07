lst_x = []
lst_y = []
for i in range(3):
    x, y = map(int, input().split())
    if x in lst_x:
        lst_x.remove(x)
    else:
        lst_x.append(x)
    if y in lst_y:
        lst_y.remove(y)
    else:
        lst_y.append(y)

print(lst_x[0], lst_y[0])

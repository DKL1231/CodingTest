row, col = map(int, input().split())

result = []
for i in range(row):
    get = input()
    get = list(get)
    for j in range(col):
        if get[j] != '.':
            get[col-j-1] = get[j]
    result.append("".join(get))

for i in range(row):
    print(result[i])

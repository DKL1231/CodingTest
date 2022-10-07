def people(floor, room):
    zero = [i for i in range(room+1)]
    for i in range(floor):
        for j in range(1, room+1):
            zero[j] += zero[j-1]
    return zero[room]


inp = int(input())
result = []
for i in range(inp):
    k = int(input())
    n = int(input())
    result.append(people(k, n))

for i in range(inp):
    print(result[i])

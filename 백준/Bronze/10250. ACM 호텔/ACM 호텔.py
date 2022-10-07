inp = int(input())

result = []
for i in range(inp):
    h, w, n = map(int, input().split())
    floor = n % h
    room = n // h + 1
    if floor == 0:
        floor = h
        room = n // h
    room = str(room).rjust(2, '0')
    result.append(f'{floor}'+room)

for i in range(inp):
    print(result[i])

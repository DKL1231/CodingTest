inp = input()

total = 0
for i in range(len(inp)):
    tmp = ord(inp[i])
    if (tmp >= ord('A')) & (tmp <= ord('C')):
        total += 3
    elif tmp <= ord('F'):
        total += 4
    elif tmp <= ord('I'):
        total += 5
    elif tmp <= ord('L'):
        total += 6
    elif tmp <= ord('O'):
        total += 7
    elif tmp <= ord('S'):
        total += 8
    elif tmp <= ord('V'):
        total += 9
    elif tmp <= ord('Z'):
        total += 10

print(total)

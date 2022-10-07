inp = input()
inp = inp.upper()
lst = [0 for i in range(26)]

for i in range(len(inp)):
    lst[ord(inp[i])-65] += 1  # A~Z = ASCII 65~90

mst_used = -1  # for count
mst_used_index = -1  # for index
check = True
for i in range(26):
    if mst_used < lst[i]:
        check = True
        mst_used = lst[i]
        mst_used_index = i
    elif mst_used == lst[i]:
        check = False

if not check:
    print('?')
else:
    print(chr(65 + mst_used_index))

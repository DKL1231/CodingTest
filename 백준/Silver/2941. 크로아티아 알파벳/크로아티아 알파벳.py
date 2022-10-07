inp = input()

croatia = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']
cnt = 0
for i in range(len(croatia)):
    while croatia[i] in inp:
        inp = inp.replace(croatia[i], ' ', 1)
        cnt += 1


inp = inp.replace(' ', '')

print(cnt + len(inp))

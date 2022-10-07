def hanoi(n, start, tmp, to):
    if n == 1:
        print(start, to)
    else:
        hanoi(n-1, start, to, tmp)
        print(start, to)
        hanoi(n-1, tmp, start, to)


inp = int(input())
print(2**inp-1)
hanoi(inp, 1, 2, 3)

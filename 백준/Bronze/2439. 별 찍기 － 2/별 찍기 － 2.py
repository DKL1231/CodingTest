count = int(input())

for i in range(count):
    for j in range(count):
        if (count-1-j)>i:
            print(' ', end='')
        else:
            print("*", end='')
    print()

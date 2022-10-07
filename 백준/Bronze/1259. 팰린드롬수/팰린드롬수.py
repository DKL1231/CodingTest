while True:
    n = str(input())
    if n == "0":
        break
    check = True
    for i in range(len(n)//2):
        if n[i] != n[-1-i]:
            check = False
            break

    if check:
        print("yes")
    else:
        print("no")

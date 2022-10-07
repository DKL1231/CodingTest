import sys

while True:
    inp = list(sys.stdin.readline())
    inp.pop()
    if len(inp) == 1 and inp[0] == '.':
        break
    chk = []  # 열린 괄호 저장
    check = True
    for i in range(len(inp)):
        if inp[i] == "(":
            chk.append(1)
        elif inp[i] == "[":
            chk.append(0)
        elif inp[i] == ")":
            if len(chk) == 0:
                check = False
                break
            elif chk[len(chk)-1] == 0 or 1 not in chk:
                check = False
                break
            else:
                chk.pop()
        elif inp[i] == "]":
            if len(chk) == 0:
                check = False
                break
            elif chk[len(chk)-1] == 1 or 0 not in chk:
                check = False
                break
            else:
                chk.pop()
        else:
            continue
    if len(chk) == 0 and check:
        print("yes")
    else:
        print("no")


import sys

clt = ['a', 'e', 'i', 'o', 'u']

while True:
    s = input()
    if s == 'end':
        break
    result = True
    check_clt = False
    for i in range(len(s)):
        if s[i] in clt:
            check_clt = True
        if i >= 1:
            if s[i] == s[i-1] and s[i] not in ['e', 'o']:
                result = False
                break
        if i >= 2:
            if s[i] in clt and s[i-1] in clt and s[i-2] in clt:
                result = False
                break
            elif s[i] not in clt and s[i-1] not in clt and s[i-2] not in clt:
                result = False
                break

    print(f"<{s}> is ", end="")

    if not (result and check_clt):
        print("not ", end="")
    print("acceptable.")

import sys

t = list(map(int, sys.stdin.readline().split()))

tmp = True  # 오름차순
if t[0] > t[1]:
    tmp = False  # 내림차순
tmp2 = True
check = True
for i in range(1, len(t)):
    if t[i-1] > t[i]:
        tmp2 = False
    else:
        tmp2 = True
    if tmp2 != tmp:
        check = False

if not check:
    print("mixed")
elif tmp2:
    print("ascending")
else:
    print("descending")

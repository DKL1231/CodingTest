import sys


def star(n):
    if n == 1:
        return ['*']
    result = []
    lst = star(n/3)
    for i in lst:
        result.append(i+i+i)
    for i in lst:
        result.append(i+' '*int(n/3)+i)
    for i in lst:
        result.append(i+i+i)
    return result


n = int(sys.stdin.readline())
if n % 3 != 0:
    print("3의 거듭제곱을 입력해주세요")
else:
    star_result = star(n)
    for line in star_result:
        print(line)

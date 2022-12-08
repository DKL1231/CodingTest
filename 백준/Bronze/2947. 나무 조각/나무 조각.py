import sys

lst = list(map(int, sys.stdin.readline().split()))

def check_lst():
    for i in range(5):
        if lst[i] != i+1:
            return False
    return True

def do():
    for i in range(4):
        if lst[i] > lst[i+1]:
            tmp = lst[i]
            lst[i] = lst[i+1]
            lst[i+1] = tmp
            for num in lst:
                print(num, end=" ")
            print()

while not check_lst():
    do()
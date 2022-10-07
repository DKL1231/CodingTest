import sys

n = int(sys.stdin.readline())

inp = list(map(int, sys.stdin.readline().split()))

m = int(sys.stdin.readline())

inp2 = list(map(int, sys.stdin.readline().split()))

inp_dic = {}
for i in inp:
    inp_dic[i] = 1

for i in inp2:
    try:
        print(inp_dic[i])
    except:
        print(0)

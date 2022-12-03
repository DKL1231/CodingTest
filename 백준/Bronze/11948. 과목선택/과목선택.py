import sys

sci = []
for i in range(4):
    sci.append(int(sys.stdin.readline()))

yj = []
for i in range(2):
    yj.append(int(sys.stdin.readline()))
    

print(sum(sci)-min(sci)+max(yj))
import sys

n = int(sys.stdin.readline())

f = {}
for i in range(n):
    s = sys.stdin.readline()[:-1]
    s = s[s.find('.')+1:]
    
    if s in f.keys():
        f[s] = f[s]+1
    else:
        f[s] = 1

s_f = sorted(f.items(), key = lambda item: item[0])

for k,v in s_f:
    print(k, v)
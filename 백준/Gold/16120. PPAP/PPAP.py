from collections import deque
s = input()
visit = [False for i in range(len(s))]
if s == "P":
    print("PPAP")
    exit()
if 1 < len(s) < 4:
    print("NP")
    exit()
elif len(s) == 4 and s != "PPAP":
    print("NP")
    exit()

cnt = 0

q = deque()
for i in range(len(s)):
    if s[i] == "P":
        cnt += 1
        q.append(i)
    else:
        if cnt<2:
            print("NP")
            exit()
        if i+1 == len(s):
            print("NP")
            exit()
        if s[i+1] == "A":
            print("NP")
            exit()
        cnt -= 2
        visit[q.pop()] = True
        visit[q.pop()] = True
        visit[i] = True
        visit[i+1] = True

for i in range(len(s)):
    if not visit[i]:
        print("NP")
        exit()
print("PPAP")
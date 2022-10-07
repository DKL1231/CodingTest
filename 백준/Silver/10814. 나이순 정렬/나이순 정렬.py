import sys

n = int(sys.stdin.readline())
people = []
for i in range(n):
    temp = sys.stdin.readline().split()
    people.append([int(temp[0]), temp[1]])
people.sort(key=lambda x: x[0])

for p in people:
    print(p[0], p[1])

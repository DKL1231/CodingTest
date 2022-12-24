import sys
from itertools import permutations
p_order = []

def play_game():
    global n, result, p_order
    score = 0
    p_ptr = 0
    for play in inning:
        three_out = False
        out = 0
        b1 = 0
        b2 = 0
        b3 = 0
        while not three_out:
            for j in range(p_ptr, 9):
                tmp = play[p_order[j]]
                if tmp == 0:
                    out += 1
                    if out == 3:
                        three_out = True
                        p_ptr = (j + 1) % 9
                        break
                elif tmp == 1:
                    score += b3
                    b1, b2, b3 = 1, b1, b2
                elif tmp == 2:
                    score += b2 + b3
                    b1, b2, b3 = 0, 1, b1
                elif tmp == 3:
                    score += b1 + b2 + b3
                    b1, b2, b3 = 0, 0, 1
                else:
                    score += b1 + b2 + b3 + 1
                    b1, b2, b3 = 0, 0, 0
            if not three_out:
                p_ptr = 0
    result = max(result, score)

      
n = int(sys.stdin.readline())

inning = []

for i in range(n):
    inning.append(list(map(int, sys.stdin.readline().split())))

result = 0

for lineup in permutations(range(1, 9), 8):
    p_order = list(lineup[:3]) + [0] + list(lineup[3:])
    play_game()
print(result)
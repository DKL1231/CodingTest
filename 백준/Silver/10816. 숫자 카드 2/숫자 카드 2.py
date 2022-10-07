import sys
from collections import Counter
n = int(sys.stdin.readline())
card_sg = list(map(int, sys.stdin.readline().split()))

m = int(sys.stdin.readline())
card = list(map(int, sys.stdin.readline().split()))

count_card = Counter(card_sg)

for c in card:
    if c in count_card:
        print(count_card[c], end=' ')
    else:
        print(0, end=' ')

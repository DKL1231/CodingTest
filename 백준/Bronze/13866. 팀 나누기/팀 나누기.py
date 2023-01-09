import sys

s = list(map(int, sys.stdin.readline().split()))

team1 = min(s)+max(s)
team2 = sum(s) - team1

print(abs(team1-team2))
def solution(cards1, cards2, goal):
    for card in goal:
        if cards1 and card == cards1[0]:
            cards1 = cards1[1:]
        elif cards2 and card == cards2[0]:
            cards2 = cards2[1:]
        else:
            return "No"
    return "Yes"
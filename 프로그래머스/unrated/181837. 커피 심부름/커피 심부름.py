def solution(order):
    answer = 0
    for coffee in order:
        if 'americano' in coffee or 'anything' in coffee:
            answer += 4500
        else:
            answer += 5000
    return answer
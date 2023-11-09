def solution(people, limit):
    answer = 0
    people.sort()
    pf, pe = 0, len(people)-1
    while pf <= pe:
        if people[pf]+people[pe] > limit:
            answer += 1
            pe -= 1
        else:
            answer += 1
            pe -= 1
            pf += 1
    return answer
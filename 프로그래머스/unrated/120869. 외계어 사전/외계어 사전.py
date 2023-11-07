def solution(spell, dic):
    spell.sort()
    for s in dic:
        tmp = list(s)
        tmp.sort()
        if spell == tmp:
            return 1
    return 2
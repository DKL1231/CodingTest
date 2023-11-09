def solution(k, tangerine):
    s_t = set(tangerine)
    tangerine.sort()
    new_l = []
    pf, pe = 0, 0
    
    for i, t in enumerate(tangerine):
        if i:
            if tangerine[i-1] != t:
                new_l.append(pe-pf+1)
                pf, pe = i, i
            else:
                pe += 1
    new_l.append(pe-pf+1)
    new_l.sort(reverse=True)
    cnt = 0
    for t_c in new_l:
        if k <= 0:
            break
        else:
            k -= t_c
            cnt += 1
    return cnt
def solution(s):
    answer = 0
    dic = {']':'[', ')':'(', '}':'{'}
    for i in range(len(s)):
        tmp = list(s)[i:]
        tmp.extend(list(s)[:i])
        stk = ['' for i in range(len(s))]
        p = -1
        flag = True
        for j in range(len(s)):
            if tmp[j] in ('[', '(', '{'):
                p += 1
                stk[p] = tmp[j]
            else:
                if tmp[j] in dic.keys():
                    if p == -1 or stk[p] != dic[tmp[j]]:
                        flag = False
                        break
                    else:
                        p -= 1
        if flag and p == -1:
            answer+=1
    return answer
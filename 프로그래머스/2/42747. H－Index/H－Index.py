def solution(citations):
    citations.sort(reverse=True)
    tmp = citations[0]
    idx = 0
    cnt = 1
    while tmp>=0:
        if tmp <= cnt:
            return tmp
        else:
            tmp -= 1
            try:
                while tmp == citations[idx+1]:
                    idx += 1
                    cnt += 1
            except:
                pass
        
    return 0
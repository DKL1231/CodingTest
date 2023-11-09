def solution(name, yearning, photo):
    dic = {}
    for n, y in zip(name, yearning):
        dic[n] = y
    answer = [0 for i in range(len(photo))]
    for i, p in enumerate(photo):
        for person in p:
            try:
                answer[i] += dic[person]
            except:
                pass
    return answer
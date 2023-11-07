def solution(s):
    answer = 0
    cnt = 0
    while s != "1":
        prv = s
        s = s.replace("0", "")
        answer += len(prv)-len(s)
        s = str(bin(len(s)))[2:]
        cnt += 1
    return [cnt, answer]
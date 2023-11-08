def solution(rank, attendance):
    answer = []
    for r, a, idx in sorted(zip(rank, attendance, [i for i in range(len(rank))])):
        if a:
            answer.append(idx)
    return answer[0]*10000+answer[1]*100+answer[2]
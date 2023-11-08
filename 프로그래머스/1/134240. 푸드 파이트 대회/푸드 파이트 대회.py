def solution(food):
    answer = []
    for i in range(1, len(food)):
        answer.append(f'{i}'*(food[i]//2))
    r_answer = answer.copy()
    r_answer.reverse()
    answer = "".join(answer)+'0'+"".join(r_answer)    
    return answer
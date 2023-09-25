def solution(board, k):
    answer = 0
    for i in range(k+1):
        for j in range(i+1):
            try:
                answer += board[j][i-j]
            except:
                pass
    return answer
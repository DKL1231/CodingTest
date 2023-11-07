def solution(keyinput, board):
    mv = [[0, 1], [-1, 0], [0, -1], [1, 0]]
    trans = {"up":0, "down":2, "left":1, "right":3}
    answer = [0, 0]
    xlim, ylim = (board[0]-1)//2, (board[1]-1)//2
    for k in keyinput:
        move = mv[trans[k]]
        if abs(answer[0]+move[0]) > xlim or abs(answer[1]+move[1]) > ylim:
            pass
        else:
            answer = [answer[0]+move[0],answer[1]+move[1]]
    return answer
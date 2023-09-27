def solution(myStr):
    myStr = myStr.replace('a', ' ')
    myStr = myStr.replace('b', ' ')
    myStr = myStr.replace('c', ' ')
    myStr = ' '.join(myStr.split())
    answer = list(myStr.split())
    return answer if answer else ["EMPTY"] 
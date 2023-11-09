def solution(a, b):
    m = [0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    dic = {1:'FRI', 2:'SAT', 3:'SUN', 4:'MON', 5:'TUE', 6:'WED', 0:'THU'}
    date = sum(m[:a])+b
    
    return dic[date%7]
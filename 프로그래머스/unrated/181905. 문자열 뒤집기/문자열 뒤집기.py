def solution(my_string, s, e):
    tmp = list(my_string[s:e+1])
    tmp.reverse()
    return my_string[:s]+''.join(tmp)+my_string[e+1:]
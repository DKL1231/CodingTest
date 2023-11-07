def solution(my_string, queries):
    for s, e in queries:
        tmp = list(my_string[s:e+1])
        tmp.reverse()
        tmp = "".join(tmp)
        my_string = my_string[:s]+tmp+my_string[e+1:]
    return my_string
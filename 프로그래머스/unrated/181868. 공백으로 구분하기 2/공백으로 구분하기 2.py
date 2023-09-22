def solution(my_string):
    prev = ""
    while prev != my_string:
        prev = my_string
        my_string = my_string.replace("  ", " ")
    temp = list(my_string.split(" "))
    answer = []
    for s in temp:
        if len(s):
            answer.append(s)
    return answer
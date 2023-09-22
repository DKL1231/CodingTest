def solution(myString):
    return sorted(list(filter(None,myString.split("x"))))
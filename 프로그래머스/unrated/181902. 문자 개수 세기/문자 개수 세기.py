def solution(my_string):
    return [my_string.count(chr(i)) for i in range(ord('A'), ord('Z')+1)]+[my_string.count(chr(i)) for i in range(ord('a'), ord('z')+1)]
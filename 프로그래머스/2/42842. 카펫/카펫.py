def solution(brown, yellow):
    for i in range(1, yellow+1):
        if not yellow%i:
            if 4+2*(i+yellow//(i)) == brown:
                return(max(i+2,yellow//i+2), min(i+2,yellow//i+2))
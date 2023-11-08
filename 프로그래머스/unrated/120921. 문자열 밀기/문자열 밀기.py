def solution(A, B):
    A = list(A)
    B = list(B)
    for i in range(len(A)):
        if A==B:
            return i
        else:
            A = [A[-1]]+A[:len(A)-1]
    return -1
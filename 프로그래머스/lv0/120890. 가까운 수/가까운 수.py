def solution(array, n):
    array.append(n)
    array.sort()
    num1 = 200 if array.index(n)-1<0 else array[array.index(n)-1]
    num2 = 200 if array.index(n)+1>=len(array) else array[array.index(n)+1]
    if abs(num1-n) <= abs(num2-n):
        return num1
    else:
        return num2
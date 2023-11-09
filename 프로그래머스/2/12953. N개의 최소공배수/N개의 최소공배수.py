def solution(arr):
    import math
    
    for i in range(1, len(arr)):
        arr[i] = arr[i]*arr[i-1]//math.gcd(arr[i], arr[i-1])
    return arr[len(arr)-1]*arr[len(arr)-2]//math.gcd(arr[len(arr)-1],arr[len(arr)-2])
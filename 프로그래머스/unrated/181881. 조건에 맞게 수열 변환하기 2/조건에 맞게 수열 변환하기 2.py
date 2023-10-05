def solution(arr):
    prv = []
    cnt = -1
    while prv != arr:
        prv = arr.copy()
        for i, num in enumerate(arr):
            if num >= 50 and num%2 == 0:
                arr[i] = num//2
            elif num < 50 and num%2:
                arr[i] = num*2+1
        cnt += 1
    return cnt
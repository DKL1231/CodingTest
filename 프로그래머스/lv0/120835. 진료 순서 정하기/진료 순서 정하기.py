def solution(emergency):
    tmp = emergency.copy()
    tmp.sort(reverse=True)
        
    return [tmp.index(em)+1 for em in emergency]
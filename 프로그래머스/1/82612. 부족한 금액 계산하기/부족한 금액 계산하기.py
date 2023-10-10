def solution(price, money, count):
    price = int(price*(count+1)*(count/2))
    return max(price-money, 0)
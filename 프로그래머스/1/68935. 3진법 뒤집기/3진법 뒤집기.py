def solution(n):
    def f(n, q):
        rev_base = ''
        while n > 0:
            n, mod = divmod(n, q)
            rev_base += str(mod)
        return rev_base
    return int(f(n, 3),3)
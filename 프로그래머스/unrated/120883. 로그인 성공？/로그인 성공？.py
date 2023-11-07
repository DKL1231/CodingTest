def solution(id_pw, db):
    if id_pw in db:
        return "login"
    iddb = [id for id, pw in db]
    
    if id_pw[0] not in iddb:
        return "fail"
    return "wrong pw"
select ID, EMAIL, FIRST_NAME, LAST_NAME
from DEVELOPERS as D
where SKILL_CODE > (
    select MIN(D.SKILL_CODE ^ S.CODE)
    from SKILLCODES as S
    where S.NAME in ("Python", "C#")
)
order by ID;
SELECT
    EMP_NO,
    EMP_NAME,
    GRADE,
    CASE 
        WHEN GRADE = 'S' THEN SAL * 0.2
        WHEN GRADE = 'A' THEN SAL * 0.15
        WHEN GRADE = 'B' THEN SAL * 0.1
        ELSE 0
    END AS BONUS
FROM (
    SELECT
        A.EMP_NO,
        A.EMP_NAME,
        A.SAL,
        CASE
            WHEN AVG(B.SCORE) >= 96 THEN 'S'
            WHEN AVG(B.SCORE) >= 90 THEN 'A'
            WHEN AVG(B.SCORE) >= 80 THEN 'B'
            ELSE 'C'
        END AS GRADE
    FROM HR_EMPLOYEES A
    JOIN HR_GRADE B ON A.EMP_NO = B.EMP_NO
    GROUP BY A.EMP_NO, A.EMP_NAME, A.SAL
) T
ORDER BY EMP_NO ASC;

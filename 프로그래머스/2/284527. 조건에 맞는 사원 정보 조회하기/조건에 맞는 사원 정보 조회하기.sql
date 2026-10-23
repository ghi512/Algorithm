-- 2022년도 한해 평가 점수가 가장 높은 사원 정보를 조회하려 합니다. 
-- 2022년도 평가 점수가 가장 높은 사원들의 점수, 사번, 성명, 직책, 이메일을 조회하는 SQL문을 작성해주세요. 
-- 2022년도의 평가 점수는 상,하반기 점수의 합을 의미하고, 평가 점수를 나타내는 컬럼의 이름은 SCORE로 해주세요.

SELECT
    SUM(A.SCORE) AS SCORE,
    A.EMP_NO,
    B.EMP_NAME,
    B.POSITION,
    B.EMAIL
FROM HR_GRADE A
JOIN HR_EMPLOYEES B ON A.EMP_NO = B.EMP_NO
GROUP BY
    A.EMP_NO,
    B.EMP_NAME,
    B.POSITION,
    B.EMAIL
HAVING SUM(A.SCORE) = (
    SELECT MAX(T.TOTAL)
    FROM (
        SELECT SUM(SCORE) AS TOTAL
        FROM HR_GRADE
        GROUP BY EMP_NO
    ) T
);
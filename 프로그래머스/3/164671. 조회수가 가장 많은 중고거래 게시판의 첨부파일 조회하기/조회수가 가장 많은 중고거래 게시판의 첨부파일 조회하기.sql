-- 조회수(VIEWS)가 가장 높은 MAX - 1개
-- 중고거래 게시물에 대한 첨부파일 경로 조회 
-- /home/grep/src/B0001/IMG_000001photo1.jpg

SELECT 
    CONCAT(
        '/home/grep/src/', B.BOARD_ID, '/', B.FILE_ID, B.FILE_NAME, B.FILE_EXT
          ) AS FILE_PATH
FROM USED_GOODS_BOARD A 
JOIN USED_GOODS_FILE B ON A.BOARD_ID = B.BOARD_ID
WHERE A.VIEWS = (
    SELECT MAX(VIEWS)
    FROM USED_GOODS_BOARD
)
ORDER BY FILE_PATH DESC;
-- 아이템의 희귀도가 'RARE'인 아이템들의 모든 다음 업그레이드 아이템의 
-- 아이템 ID(ITEM_ID), 아이템 명(ITEM_NAME), 아이템의 희귀도(RARITY)를
-- 결과는 아이템 ID를 기준으로 내림차순 정렬주세요.

SELECT 
    B.ITEM_ID,
    B.ITEM_NAME,
    B.RARITY
FROM ITEM_TREE A
JOIN ITEM_INFO B ON A.ITEM_ID = B.ITEM_ID -- 다음 아이템 (자식)
JOIN ITEM_INFO C ON A.PARENT_ITEM_ID = C.ITEM_ID -- 기준 아이템 (부모)
WHERE C.RARITY = 'RARE'
ORDER BY B.ITEM_ID DESC;
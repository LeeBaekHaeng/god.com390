SELECT
	A.USER_ID,
	A.USER_NM,
	A.USER_SE,
	B.IP_INFO,
	B.DPLCT_PERM_AT,
	B.LMTT_AT,
	B.LAST_UPDUSR_ID,
	B.LAST_UPDT_PNTTM,
	IF(B.EMPLYR_ID IS NULL,
	'N',
	'Y') AS REG_YN
FROM
	COMVNUSERMASTER A
LEFT OUTER JOIN COMTNLOGINPOLICY B ON
	A.USER_ID = B.EMPLYR_ID
WHERE
	1 = 1
LIMIT 10 OFFSET 0;

select
	A.USER_ID,
	A.USER_NM,
	A.USER_SE,
	B.IP_INFO,
	B.DPLCT_PERM_AT,
	B.LMTT_AT,
	B.LAST_UPDUSR_ID,
	B.LAST_UPDT_PNTTM,
	if(B.EMPLYR_ID is null,
	'N',
	'Y') as REG_YN
from
	COMVNUSERMASTER A
left outer join COMTNLOGINPOLICY B on
	A.USER_ID = B.EMPLYR_ID
where
	1 = 1
	and A.USER_NM like CONCAT('%' , '테스트1', '%')
limit 10 OFFSET 0 ;

select
	A.USER_ID,
	A.USER_NM,
	A.USER_SE,
	B.IP_INFO,
	B.DPLCT_PERM_AT,
	if(B.LMTT_AT is null,
	'N',
	B.LMTT_AT) as LMTT_AT,
	B.LAST_UPDUSR_ID,
	B.LAST_UPDT_PNTTM,
	if(B.EMPLYR_ID is null,
	'N',
	'Y') as REG_YN
from
	COMVNUSERMASTER A
left outer join COMTNLOGINPOLICY B on
	A.USER_ID = B.EMPLYR_ID
where
	1 = 1
	and A.USER_ID = 'TEST1'
;

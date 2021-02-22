SELECT * FROM COMTNENTRPRSMBER /* 기업회원 */
;

SELECT * FROM comtnentrprsmber /* 기업회원 */
;

select
	c.COLUMN_NAME,
	c.IS_NULLABLE,
	c.DATA_TYPE,
	c.CHARACTER_MAXIMUM_LENGTH,
	c.COLUMN_KEY,
	c.*
from information_schema.`COLUMNS` c
where TABLE_SCHEMA = 'com'
	and TABLE_NAME = 'comtnentrprsmber'
;

select * from comvnusermaster;

-- 	<!-- 인증서 로그인 -->
-- 	<select id="actionCrtfctLogin" resultMap="login">
		
		SELECT emplyr_id AS id
		     , user_nm AS name
		     , password AS password
		     , ihidnum AS ihidNum
		     , email_adres AS email
		     , 'USR' AS userSe
		     , orgnzt_id AS orgnztId
		     , esntl_id AS uniqId
, CRTFC_DN_VALUE
		  FROM COMTNEMPLYRINFO
-- 		 WHERE CRTFC_DN_VALUE = #{dn}
		
-- 	</select>
;

SELECT mber_nm, mber_email_adres, mber_id
FROM COMTNGNRLMBER
;

SELECT cmpny_nm, applcnt_email_adres, ENTRPRS_MBER_ID
FROM COMTNENTRPRSMBER
;

SELECT user_nm, email_adres, emplyr_id
FROM COMTNEMPLYRINFO
;

SELECT mber_id AS id FROM COMTNGNRLMBER WHERE mber_nm = '일반회원' AND mber_email_adres = 'egovframesupport@gmail.com' 
AND mber_sttus = 'P'
;

SELECT ENTRPRS_MBER_ID AS id FROM COMTNENTRPRSMBER
-- WHERE cmpny_nm = '테스트1'
-- AND applcnt_email_adres = 'egovframesupport@gmail.com'
-- AND entrprs_mber_sttus = 'P'
;

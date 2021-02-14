SELECT * FROM COMTNENTRPRSMBER /* 기업회원 */
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

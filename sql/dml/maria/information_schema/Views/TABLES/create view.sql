-- CREATE OR REPLACE VIEW com.administ_code AS select * from comtcadministcode;

select
	concat('CREATE OR REPLACE VIEW ', TABLE_NAME, ' AS select * from ', TABLE_NAME, ';')
from
	information_schema.TABLES
where
	1 = 1
	and TABLE_SCHEMA = 'com'
;

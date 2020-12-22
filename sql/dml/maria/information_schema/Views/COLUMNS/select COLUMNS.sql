select
	TABLE_CATALOG,
	TABLE_SCHEMA,
	TABLE_NAME,
	COLUMN_NAME,
	ORDINAL_POSITION,
	COLUMN_DEFAULT,
	IS_NULLABLE,
	DATA_TYPE,
	CHARACTER_MAXIMUM_LENGTH,
	CHARACTER_OCTET_LENGTH,
	NUMERIC_PRECISION,
	NUMERIC_SCALE,
	DATETIME_PRECISION,
	CHARACTER_SET_NAME,
	COLLATION_NAME,
	COLUMN_TYPE,
	COLUMN_KEY,
	EXTRA,
	`PRIVILEGES`,
	COLUMN_COMMENT,
	IS_GENERATED,
	GENERATION_EXPRESSION
from
	information_schema.`COLUMNS`
where 1 = 1
	and TABLE_SCHEMA = 'com'	
-- 	and TABLE_NAME = 'comtcadministcode'
;

select
	*
from
	COMTNAUTHORROLERELATE /* 권한롤관계 */;

select
	*
from
	COMTNROLEINFO A
left outer join (
	select
		AUTHOR_CODE ,
		ROLE_CODE,
		CREAT_DT
	from
		COMTNAUTHORROLERELATE
	where
		AUTHOR_CODE = 'ROLE_ANONYMOUS') B on
	A.ROLE_CODE = B.ROLE_CODE ;

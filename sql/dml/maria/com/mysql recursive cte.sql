/*
WITH RECURSIVE employee_paths (id, name, path) AS
(
  SELECT id, name, CAST(id AS CHAR(200))
    FROM employees
    WHERE manager_id IS NULL
  UNION ALL
  SELECT e.id, e.name, CONCAT(ep.path, ',', e.id)
    FROM employee_paths AS ep JOIN employees AS e
      ON ep.id = e.manager_id
)
SELECT * FROM employee_paths ORDER BY path;
*/

select * from comtnmenuinfo
;

WITH RECURSIVE employee_paths (MENU_NO, MENU_NM, path, UPPER_MENU_NO) AS
(
  SELECT MENU_NO, MENU_NM, CAST(lpad(MENU_ORDR, 3, '0') AS CHAR(200)), UPPER_MENU_NO
    FROM comtnmenuinfo
    WHERE UPPER_MENU_NO = 0 and MENU_NO != 0
  UNION ALL
  SELECT e.MENU_NO, e.MENU_NM, CONCAT(ep.path, ',', lpad(e.MENU_ORDR, 3, '0')), e.UPPER_MENU_NO
    FROM employee_paths AS ep JOIN comtnmenuinfo AS e
      ON ep.MENU_NO = e.UPPER_MENU_NO
)
select
MENU_NO, MENU_NM, path, UPPER_MENU_NO,
 char_length(path) - char_length(replace(path, ',', '')) + 1 level
FROM employee_paths ORDER BY path;

select * from COMTNAUTHORROLERELATE;

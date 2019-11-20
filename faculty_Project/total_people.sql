CREATE FUNCTION total_people(INT) RETURNS INT AS $$

DECLARE
	project_no ALIAS FOR $1;
	prof INT;
	std INT;
	mng INT;
BEGIN
SELECT COUNT(*) INTO prof FROM work_proj_professors
WHERE pid=project_no;

SELECT COUNT(*) INTO std FROM work_proj_students
WHERE pid=project_no;

SELECT COUNT(*) INTO mng FROM manage_proj
WHERE pid=project_no;


RETURN prof+std+mng;
END;

$$ LANGUAGE 'plpgsql';





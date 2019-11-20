CREATE FUNCTION female_faculty() RETURNS float AS $$

DECLARE
	f_prof float;
	prof float;
	res Numeric(4,2);
BEGIN
SELECT COUNT(*) INTO f_prof FROM professor
WHERE gender='F';

SELECT COUNT(*) INTO prof FROM professor;

res = (f_prof*100)/prof;
RETURN res;
END;

$$ LANGUAGE 'plpgsql';




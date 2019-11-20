CREATE FUNCTION student_restrict_trig() RETURNS trigger AS $$
DECLARE
num INT;
BEGIN

SELECT COUNT(*) INTO num FROM work_proj_students WHERE sssn = NEW.sssn;
IF  num=2
THEN RAISE EXCEPTION 'each student should works on no more than two projects';
END IF;

RETURN NEW;
END;
$$ LANGUAGE 'plpgsql';




CREATE TRIGGER  student_restrict 
BEFORE INSERT OR UPDATE
ON work_proj_students
FOR EACH ROW EXECUTE PROCEDURE student_restrict_trig();




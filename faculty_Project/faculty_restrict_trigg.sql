CREATE FUNCTION faculty_restrict_trig() RETURNS trigger AS $$
DECLARE
COPI INT;
BEGIN

SELECT COUNT(*) INTO COPI FROM work_proj_professors WHERE pid = NEW.pid;
IF  COPI = 4 
THEN RAISE EXCEPTION 'each project should have at most 4 faculty members as CO-PI';
END IF;

RETURN NEW;
END;

$$ LANGUAGE 'plpgsql';




CREATE TRIGGER  faculty_restrict 
BEFORE INSERT OR UPDATE
ON work_proj_professors
FOR EACH ROW EXECUTE PROCEDURE faculty_restrict_trig();



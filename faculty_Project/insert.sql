INSERT INTO public.professor(
	pssn, Name, age, gender, rank, speciality)
	VALUES (1234567890, 'Pedro ponce',29, 'M', 1, 'NONE'),
	 (1111111111, 'peter Cornejo',30, 'M', 1, 'NONE'),
	 (2222222222, 'Cynthia Ramos',31, 'F', 1, 'NONE'),
	 (3333333333, 'Allen Jones',31, 'M', 1, 'NONE'),
	 (8888888888, 'Jane Doe', 32,'F', 1, 'NONE'),
	 (7777777777, 'John Doe',33, 'M', 1, 'NONE'),
	 (1111111000, 'Pedro Martinez',30, 'M', 1, 'NONE'),
	 (2222222000, 'Cynthia Martinez',31, 'F', 1, 'NONE'),
	 (3333333000, 'Amy Jones',31, 'F', 1, 'NONE'),
	 (8888888000, 'Nicole Doe', 32,'F', 1, 'NONE'),
	 (7777777000, 'John Doe',33, 'M', 1, 'NONE'),
	 (1111111001, 'Chantel Johnson',32, 'F', 1, 'NONE');
	
INSERT INTO public.dapartment(
	dno, dname, office)
	VALUES (1, 'Computer Science', '101E'),
	(2,'Electrical Engineering' , '102E'),
	(3, 'Public Health', '303C'),
	(4, 'Nursing', '304C'),
	(5, 'Fine Art', '401A'),
	(6, 'Art', '401E'),
	(7, 'Biology', '401B'),
	(8, 'Geology', '301B'),
	(9, 'Mechanical Engineering', '301E'),
	(10, 'Latin American Studies', '301A');
	
INSERT INTO public.project(
	pid, sponsor, start_date, end_date, budget)
	VALUES (1, 'Boeing', '2016-08-01', '2017-09-01', 150000),
	 (2, 'XYZ', '2017-03-01', '2017-09-01', 1200000),
	 (3, 'ABC', '2017-04-01', '2017-10-01', 999000),
	 (4, 'NASA', '2017-08-01', '2018-11-01', 140000),
	 (5, 'LA COUNTY', '2017-08-09', '2018-09-01', 1320304),
	 (6, 'Apple', '2017-09-01', '2018-11-01', 130020);
	
INSERT INTO public.student(
	sssn, name, age, gender, degree_prog, major)
	VALUES ('S123456789', 'Jerome Cavada', 19,'M','Computer Science' , 1),
	('S123456788', 'Amber Hayes', 18,'F','Computer Science' , 1),
	('S123456787', 'Christian Press', 19,'M','Art' , 6),
	('S123456786', 'Chanon Ming', 18,'M','Art' , 6),
	('S123456785', 'Elysse Rodriguez', 18,'F','Nursing' , 4),
	('S123456784', 'Peter Doe', 19,'M','Biology' , 7),
	('S123456783', 'Joel Press', 19,'M','Geology' , 8),
	('S123456782', 'Oscar Lee', 21,'M','Mechanical Engineering' , 9),
	('S123456781', 'Cindy Rodriguez', 19,'F','Mechanical Engineering' , 9),
	('S123456780', 'Eric Stone', 24,'M','Mechanical Engineering' , 9),
	('S123456779', 'Tiffany Lew', 23,'F','Public Health' , 3),
	('S123456778', 'Jennifer Haut', 22,'F','Latin American Studies' , 10),
	('S123456777', 'Miriam Sims', 21,'F','Computer Science' , 1)
;

INSERT INTO public.runs(
	dno, pssn)
	VALUES (1,1234567890),
	(2, 1111111111),
	(3, 2222222222),
	(4, 3333333333),
	(5, 8888888888),
	(6, 7777777777),
	(7, 1111111000),
	(8, 2222222000),
	(9, 3333333000),
	(10, 8888888000)	
	;
	
INSERT INTO public.work_department(
	dno, pssn)
	VALUES (1,1234567890),
	(2, 1111111111),
	(3, 2222222222),
	(4, 3333333333),
	(5, 8888888888),
	(6, 7777777777),
	(7, 1111111000),
	(8, 2222222000),
	(9, 3333333000),
	(10, 8888888000),
	(2, 7777777000),
	(3, 1111111001)
	;
	
INSERT INTO public.manage_proj(
	pid, pssn)
	VALUES (1, 1234567890),
	(2, 7777777000),
	(3, 1234567890),
	(4, 7777777000),
	(5, 7777777777),
	(6, 1111111111)	
	;
	
INSERT INTO public.work_proj_professors(
	pid, pssn)
VALUES (1, 1234567890),
	(2, 7777777000),
	(3, 1234567890),
	(4, 2222222000),
	(5, 7777777777),
	(2, 1234567890),
	(3, 2222222000),
	(4, 1111111111),
	(5, 1111111111),
	(6, 2222222000),
	(3,	7777777000),
	(3,	7777777777)		
	;
	
INSERT INTO public.work_proj_students(
	pid, sssn)
VALUES (3, 'S123456788'),
	(2, 'S123456788')
	;


	
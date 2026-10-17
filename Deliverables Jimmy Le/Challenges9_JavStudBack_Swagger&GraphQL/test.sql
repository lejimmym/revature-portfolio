SELECT table_name FROM information_schema.tables WHERE table_schema = 'public';

SELECT * from student;

select * from course;

select * from enrollment;

select * from school;



INSERT INTO school (name)
VALUES ('University of Texas');

INSERT INTO student (first_name, last_name, email, school_id)
VALUES ('Alex', 'Nguyen', 'alex.nguyen@example.com', 1);

INSERT INTO course (name)
VALUES ('Introduction to Java');

INSERT INTO enrollment (enrollment_date, grade, course_id, student_id)
VALUES ('2026-09-01', 'A', 1, 1);
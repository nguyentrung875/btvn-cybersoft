CREATE DATABASE baitapbuoi19;
USE baitapbuoi19;

CREATE TABLE employees (
    employee_id INT PRIMARY KEY,
    name VARCHAR(100),
    department_id INT,
    manager_id INT,
    salary DECIMAL(10, 2)
);

INSERT INTO employees (employee_id, name, department_id, manager_id, salary) VALUES
(1, 'Alice', 1, NULL, 60000),
(2, 'Bob', 1, 1, 55000),
(3, 'Charlie', 2, 1, 70000),
(4, 'David', 2, 3, 65000),
(5, 'Eve', 3, 1, 62000),
(6, 'Frank', 3, 5, 58000),
(7, 'Grace', 4, 1, 72000),
(8, 'Heidi', 4, 7, 71000),
(9, 'Ivan', 5, 1, 75000),
(10, 'Judy', 5, 9, 68000);

CREATE TABLE departments (
    department_id INT PRIMARY KEY,
    department_name VARCHAR(100)
);

INSERT INTO departments (department_id, department_name) VALUES
(1, 'HR'),
(2, 'Engineering'),
(3, 'Marketing'),
(4, 'Sales'),
(5, 'Finance');

CREATE TABLE projects (
    project_id INT PRIMARY KEY,
    project_name VARCHAR(100),
    department_id INT
);

INSERT INTO projects (project_id, project_name, department_id) VALUES
(1, 'Project A', 1),
(2, 'Project B', 2),
(3, 'Project C', 2),
(4, 'Project D', 3),
(5, 'Project E', 4),
(6, 'Project F', 5),
(7, 'Project G', 1),
(8, 'Project H', 3),
(9, 'Project I', 4),
(10, 'Project J', 5);

CREATE TABLE employee_projects (
    employee_id INT,
    project_id INT,
    PRIMARY KEY (employee_id, project_id)
);

INSERT INTO employee_projects (employee_id, project_id) VALUES
(1, 1),
(1, 7),
(2, 1),
(3, 2),
(3, 3),
(4, 2),
(4, 3),
(5, 4),
(5, 8),
(6, 4),
(6, 8),
(7, 5),
(7, 9),
(8, 5),
(8, 9),
(9, 6),
(9, 10),
(10, 6),
(10, 10);

-- 1)	Liệt kê tên nhân viên và tên phòng ban của họ
SELECT e.name , d.department_name 
FROM employees e 
JOIN departments d ON e.department_id = d.department_id ;

-- 2)	Liệt kê tên nhân viên và tên dự án mà họ tham gia
SELECT e.name , p.project_name 
FROM employees e 
JOIN employee_projects ep ON ep.employee_id = e.employee_id 
JOIN projects p ON p.project_id = ep.project_id;

-- 3)	Liệt kê tên phòng ban, tên dự án và tên nhân viên tham gia dự án đó.
SELECT d.department_name , p.project_name , e.name 
FROM departments d 
JOIN projects p ON p.department_id = d.department_id
JOIN employee_projects ep ON ep.project_id = p.project_id 
JOIN employees e ON e.employee_id = ep.employee_id ;

-- 4)	Tính tổng lương của nhân viên tham gia từng dự án
SELECT p.project_name , SUM(e.salary) AS tongluong
FROM employees e 
JOIN employee_projects ep ON e.employee_id = ep.employee_id 
JOIN projects p ON p.project_id = ep.project_id 
GROUP BY p.project_name;

-- 5)	Liệt kê tên nhân viên, tên quản lý của họ và tên dự án họ tham gia
SELECT e.name AS employee_name, m.name AS manager, p.project_name
FROM employees e
JOIN employees m ON e.manager_id = m.employee_id
JOIN employee_projects ep ON e.employee_id = ep.employee_id
JOIN projects p ON ep.project_id  = p.project_id ;

-- 6)	Liệt kê tên phòng ban và số lượng nhân viên tham gia dự án của từng phòng ban
WITH temp_6 AS (SELECT d.department_name , p.project_name, ep.employee_id
FROM departments d 
JOIN projects p ON p.department_id = d.department_id
JOIN employee_projects ep ON ep.project_id  = p.project_id)
-- -
SELECT t.department_name, COUNT(DISTINCT t.employee_id) 
FROM temp_6 t
GROUP BY t.department_name

-- 7)	Tìm tên nhân viên có lương cao nhất tham gia trong mỗi dự án
WITH temp_7 AS (SELECT e.name, e.salary, p.project_name, 
			RANK() OVER(PARTITION BY p.project_name ORDER BY e.salary DESC) AS salary_rank
FROM employees e 
JOIN employee_projects ep ON e.employee_id = ep.employee_id 
JOIN projects p ON p.project_id = ep.project_id 
)
-- -
SELECT t7.project_name, t7.name, t7.salary
FROM temp_7 t7
WHERE t7.salary_rank = 1
ORDER BY t7.project_name;

-- 8)	Liệt kê tên dự án và tổng số nhân viên tham gia, sắp xếp theo tổng số nhân viên giảm dần
SELECT p.project_name , COUNT(e.employee_id) AS so_nv_tham_gia
FROM projects p 
JOIN employee_projects ep ON ep.project_id = p.project_id 
JOIN employees e ON e.employee_id = ep.employee_id 
GROUP BY p.project_name
ORDER BY so_nv_tham_gia DESC;

-- 9)	Tính lương trung bình của nhân viên trong từng phòng ban tham gia dự án
WITH temp AS (SELECT d.department_name , p.project_name, e.name, e.salary
FROM departments d 
JOIN projects p ON p.department_id = d.department_id
JOIN employee_projects ep ON ep.project_id  = p.project_id 
JOIN employees e ON e.employee_id = ep.employee_id)
-- -
SELECT t.department_name, AVG(t.salary)
FROM temp t
GROUP BY t.department_name

-- 10)	Tìm tên nhân viên và dự án mà họ tham gia ít nhất một lần trong mỗi phòng ban
SELECT e.name , p.project_name 
FROM employees e 
JOIN employee_projects ep ON ep.employee_id = e.employee_id 
JOIN projects p ON p.project_id = ep.project_id;

-- 11)	Tìm tên nhân viên và số lượng dự án mà họ tham gia nhiều nhất
SELECT e.name , COUNT(ep.project_id)
FROM employees e 
JOIN employee_projects ep ON ep.employee_id = e.employee_id 
GROUP BY e.employee_id;

-- 12)	Tìm tên phòng ban và số lượng dự án mà phòng ban đó quản lý nhiều nhất
SELECT d.department_name , COUNT(ep.project_id)
FROM departments d 
JOIN employees e ON d.department_id = e.department_id 
JOIN employee_projects ep ON ep.employee_id = e.employee_id 
GROUP BY d.department_id ;

-- 13)	Tìm tên nhân viên có lương thấp nhất trong từng dự án
WITH temp_13 AS (SELECT e.name, e.salary, p.project_name, 
			RANK() OVER(PARTITION BY p.project_name ORDER BY e.salary ASC) AS salary_rank
FROM employees e 
JOIN employee_projects ep ON e.employee_id = ep.employee_id 
JOIN projects p ON p.project_id = ep.project_id 
)
-- -
SELECT t13.project_name, t13.name, t13.salary
FROM temp_13 t13
WHERE t13.salary_rank = 1
ORDER BY t13.project_name;

-- 14)	Liệt kê tên tất cả các dự án không có nhân viên tham gia
SELECT p.project_name, COUNT(ep.employee_id) AS soluong
FROM projects p 
LEFT JOIN employee_projects ep ON ep.project_id = p.project_id
GROUP BY p.project_name 
HAVING soluong = 0
;

-- 15)	Tìm tên nhân viên có lương cao nhất và thấp nhất trong mỗi phòng ban
SELECT e.name, e.salary  , d.department_name ,
	RANK() OVER(PARTITION BY d.department_id ORDER BY e.salary) AS salary_rank
FROM employees e 
JOIN departments d ON d.department_id = e.department_id 
;

WITH temp15 AS (SELECT d.department_name, e.name , e.salary 
FROM employees e 
JOIN departments d ON d.department_id = e.department_id)
-- -
SELECT *
FROM temp15
WHERE temp15.salary IN (SELECT MIN(temp15.salary) 
					FROM temp15
					GROUP BY temp15.department_name)
	OR temp15.salary IN (SELECT MAX(temp15.salary) 
					FROM temp15
					GROUP BY temp15.department_name)
ORDER BY temp15.department_name
;

-- 17)	Tìm tên các nhân viên không tham gia bất kỳ dự án nào
SELECT e.name , ep.project_id 
FROM employees e 
LEFT JOIN employee_projects ep ON ep.employee_id = e.employee_id 
WHERE ep.project_id IS NULL OR ep.project_id = "";

-- 18)	Tính tổng số dự án mà mỗi phòng ban đang quản lý
SELECT d.department_id , d.department_name , COUNT(p.project_id) AS so_project
FROM departments d 
JOIN projects p ON p.department_id = d.department_id 
GROUP BY d.department_id ;

-- 16)	Tính tổng lương và số lượng nhân viên cho từng dự án trong mỗi phòng ban
SELECT p.project_id ,p.project_name ,
		SUM(e.salary) AS tongluong, COUNT(e.employee_id) AS sonhanvien
FROM departments d 
JOIN projects p ON p.department_id = d.department_id 
JOIN employee_projects ep ON ep.project_id = p.project_id 
JOIN employees e ON e.employee_id = ep.employee_id 
GROUP BY p.project_id 
;

-- 19)	Tìm tên nhân viên và tên dự án mà nhân viên có lương cao nhất tham gia trong từng phòng ban

SELECT e.name , p.project_name
FROM employees e 
JOIN employee_projects ep ON ep.employee_id =e.employee_id 
JOIN projects p ON p.project_id = ep.project_id
WHERE e.salary = (SELECT MAX(e.salary)
					FROM employees e);

-- 20)	Tính tổng lương của nhân viên trong mỗi phòng ban theo từng dự án mà không có nhân viên tham gia dự án
SELECT d.department_name  , SUM(e.salary) AS salary_total
FROM employees e 
LEFT JOIN employee_projects ep ON ep.employee_id = e.employee_id 
LEFT JOIN departments d ON d.department_id = e.department_id 
WHERE ep.project_id IS NULL OR ep.project_id = ""
GROUP BY d.department_id 
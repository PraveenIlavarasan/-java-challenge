CREATE TABLE employee (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  department VARCHAR(255) NOT NULL,
  emp_salary INT NOT NULL,
  created_by VARCHAR(255) NOT NULL,
  created_at DATETIME NOT NULL,
  updated_by VARCHAR(255) NOT NULL,
  updated_at DATETIME NOT NULL
);
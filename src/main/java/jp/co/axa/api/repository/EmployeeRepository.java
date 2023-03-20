package jp.co.axa.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.axa.api.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}

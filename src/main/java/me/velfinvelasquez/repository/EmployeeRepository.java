package me.velfinvelasquez.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.velfinvelasquez.models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

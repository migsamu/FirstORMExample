package org.iesfm.company.repository;

import org.iesfm.company.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository <Employee, String> {

}

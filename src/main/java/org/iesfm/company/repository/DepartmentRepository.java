package org.iesfm.company.repository;

import org.iesfm.company.Department;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, String> {


    List<Department> findByDescription(String description);

    @Query("SELECT d.* FROM Employee e INNER JOIN Department d ON d.name=e.department_name GROUP BY e.department_name HAVING count(*) = 2")
    List<Department> findDepartmentsWithTwoEmployees();
}

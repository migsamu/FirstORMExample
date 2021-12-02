package org.iesfm.company.controller;

import org.iesfm.company.Department;
import org.iesfm.company.repository.DepartmentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
public class DepartmentController {

    private DepartmentRepository departmentRepository;

    public DepartmentController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/departments")
    public void createDepartment(@RequestBody Department department) {
        departmentRepository.save(department);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/departments/{departmentName}")
    public Department get(@PathVariable("departmentName") String name) {
        return departmentRepository
                .findById(name)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Departamento no encontrado")
                );
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/departments/{departmentName}")
    public void delete(@PathVariable("departmentName") String name) {
        departmentRepository.deleteById(name);
    }

}

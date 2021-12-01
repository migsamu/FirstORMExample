package org.iesfm.company.controller;

import org.iesfm.company.Department;
import org.iesfm.company.repository.DepartmentRepository;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
public class DepartmentController {

    private DepartmentRepository departmentRepository;

    public DepartmentController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @RequestMapping(method = RequestMethod.POST, path="/departments")
    public void createDepartment(@RequestBody Department department) {

        departmentRepository.save(department);
    }

    @RequestMapping(method = RequestMethod.GET, path="/departments")
    public Iterable<Department> list(
            @RequestParam(value = "description", required = false) String description
    ) {
        if(description == null) {
            return departmentRepository.findAll();
        } else{
            return departmentRepository.findByDescription(description);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path="/departments/{departmentName}")
    public Department get(@PathVariable("departmentName") String name) {
        return departmentRepository.findById(name).get();
    }

}

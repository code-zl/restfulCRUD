package com.example.demo3.controller;

import com.example.demo3.dao.DepartmentDao;
import com.example.demo3.dao.EmployeeDao;
import com.example.demo3.entities.Department;
import com.example.demo3.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

/**
 * @author Lee
 * @create 2020-06-02 18:46
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    //thymeleaf默认的路径前缀是：classpath:/templates/，那么找到list.html就需要在templates基础上加入emp路径。这里自定义emp表示所有和用户有关的列表
    @Autowired
    DepartmentDao departmentDao;
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps", employees);
        //拿到所有的雇员信息后，需要将其放在请求域中进行共享。一般在放到方法参数的map或model或者modelMap中，他们都是在请求域中
        //在响应方法返回的页面中，可以直接调用方法中放在请求域中的变量。
        return "emp/list";
    }
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //我们希望在返回的add页面中，加入对于用户部门的选择，所以需要得到所有的部门名称
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }
}

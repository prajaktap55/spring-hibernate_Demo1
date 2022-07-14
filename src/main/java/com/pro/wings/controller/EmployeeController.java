package com.pro.wings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pro.wings.entity.Employee;
import com.pro.wings.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	@RequestMapping("/addEmployee.htm")
	public ModelAndView addEmployee(@RequestParam("name") String name, @RequestParam("salary") String sal)
	{
		ModelAndView model = new ModelAndView();
		
		model.setViewName("welcome");
		
		Employee empToPersist = new Employee();
		empToPersist.setName(name);
		empToPersist.setSalary(Integer.parseInt(sal));
		
		boolean empStored = empService.addEmployee(empToPersist);
		
		String res = null;
		if(empStored)
		{
			res = "Employee added successfully!!!!";
			model.addObject("res",res);
		}
		else
		{
			res = "Issue in adding employee!!!";
			model.addObject("res",res);
		}
		return model;
	}
}

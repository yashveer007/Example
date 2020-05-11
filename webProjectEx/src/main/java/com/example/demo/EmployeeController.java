package com.example.demo;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeReposatory empRepo;
	
	@Autowired
	private AddressReosatory addressRepo;
	
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee> >getAllEmoployees(){
		
		List<Employee> employees=empRepo.findAll();
		ResponseEntity<List<Employee>> response= new ResponseEntity<>(employees,HttpStatus.OK);
		return response;
	}
	
	@PostConstruct
	public void addEmployees(){
	      Employee employee=new Employee();
	      employee.setEmpId("101");
	      employee.setEmpName("yashveer");
	      employee.setSalary(1023212);
	     
	      Address add1= new Address();
	      add1.setCity("Amroha");
	      add1.setCountry("India");
	      add1.setPincode("244221");
	      add1.setStreet("Avas Vikas colony 1st");
	      employee.setAddress(add1);
	      empRepo.save(employee);
	      
	      Employee employee1=new Employee();
	      employee1.setEmpId("102");
	      employee1.setEmpName("yash");
	      employee1.setSalary(1023212);
	      Address add12= new Address();
	      add12.setCity("Gajrola");
	      add12.setCountry("India");
	      add12.setPincode("244241");
	      add12.setStreet("Avas Vikas colony 1st");
	      employee1.setAddress(add12);
	      empRepo.save(employee1);
	      
	 }
	
	@PostMapping("/add")
	public void ViewEmployee(@RequestBody EmployeeDto employeeDto) {
		
		System.out.println(employeeDto);
		Employee employee=convert(employeeDto);
		System.out.println(employee);
		empRepo.save(employee);
		/*
		 * ResponseEntity<List<Employee>> response= new
		 * ResponseEntity<>(employee,HttpStatus.OK); return response;
		 */
		
	}
	
	public Employee convert(EmployeeDto employeeDto) {
		System.out.println(employeeDto);
		Employee employee = new Employee();
		employee.setEmpId(employeeDto.getEmpId());
		employee.setEmpName(employeeDto.getEmpName());
		employee.setSalary(employeeDto.getSalary());
		Address  add=employee.getAddress();
		add.setStreet(employeeDto.getAddressDto().getStreet());
		add.setCity(employeeDto.getAddressDto().getCity());
		add.setCountry(employeeDto.getAddressDto().getCountry());
		add.setPincode(employeeDto.getAddressDto().getPincode());
		employee.setAddress(add);
		System.out.println(employee);
		return employee;
		
	}
	
	@GetMapping("/get/{empId}")
	public Employee getEmployeeById(@PathVariable("empId") String empId) {
		Optional<Employee> optional =empRepo.findById(empId);
        if(optional.isPresent()) {
            Employee employee=optional.get();
            return employee;
        }
			
	return null;
		
	}
}

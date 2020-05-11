package com.example.demo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Employees")
public class Employee {
	
	@Id
	private String empId;
	private String empName;
	private int salary;
	
	@OneToOne(targetEntity = Address.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "forign_key")
	private Address address;
	
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
	public Employee(String empId, String empName, int salary, Address address) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
		this.address = address;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", salary=" + salary + ", address=" + address
				+ "]";
	}
	public Employee() {
		
	}
	
}

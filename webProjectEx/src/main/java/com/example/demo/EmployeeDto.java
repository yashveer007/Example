package com.example.demo;

public class EmployeeDto {
	
	private String empId;
	private String empName;
	private int salary;
	
	private AddressDto addressDto;
	
	public AddressDto getAddressDto() {
		return addressDto;
	}
	public void setAddressDto(AddressDto addressDto) {
		this.addressDto = addressDto;
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
	@Override
	public String toString() {
		return "EmployeeDto [empId=" + empId + ", empName=" + empName + ", salary=" + salary + ", addressDto="
				+ addressDto + "]";
	}
	
	
}

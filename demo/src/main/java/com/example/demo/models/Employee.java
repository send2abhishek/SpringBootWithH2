package com.example.demo.models;



public class Employee {
	
	private int empId;
	 
	private String name;
	 
	private String Address;
	public Employee(int empId, String name, String address) {
		super();
		this.empId = empId;
		this.name = name;
		Address = address;
	}
	public int getEmpId() {
		return empId;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return Address;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", Address=" + Address + "]";
	}
	

}

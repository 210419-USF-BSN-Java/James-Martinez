package com.revature.models;

public class Employee extends Person{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int empLogin;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, String email, String password, int empLogin) {
		super(name, email, password);
		this.empLogin = empLogin;
	}

	public int getEmpLogin() {
		return empLogin;
	}

	public void setEmpLogin(int empLogin) {
		this.empLogin = empLogin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + empLogin;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (empLogin != other.empLogin)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("%-8d", empLogin)+ super.toString();
	}

	

}

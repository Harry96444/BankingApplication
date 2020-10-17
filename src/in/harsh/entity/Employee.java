package in.harsh.entity;

public class Employee {

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empBal=" + empBal + "]";
	}
	private int empId;
	private String empName;
	private int empBal;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getEmpBal() {
		return empBal;
	}
	public void setEmpBal(int empBal) {
		this.empBal = empBal;
	}
	
	
	
}

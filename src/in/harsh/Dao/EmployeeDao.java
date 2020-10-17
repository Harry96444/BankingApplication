package in.harsh.Dao;

import in.harsh.entity.Employee;
import in.harsh.exception.InSufficientFundsException;

public interface EmployeeDao {

	public abstract boolean createAccount(Employee obj);
	public abstract Employee getAccount(int empId);
	public abstract boolean closeAccount(int empId);
	boolean updateAccount(int id,char tr,int amt)throws InSufficientFundsException;
	public abstract void closeResources();
}

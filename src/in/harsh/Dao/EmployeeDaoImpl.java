package in.harsh.Dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import in.harsh.exception.InSufficientFundsException;
import in.harsh.entity.Employee;
import in.harsh.util.HibernateUtils;
import in.harsh.exception.*;
public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public boolean createAccount(Employee obj) {
		Session sess=HibernateUtils.getSessionFactory().openSession();
		Transaction tx=sess.beginTransaction();
		sess.save(obj);
		tx.commit();
		sess.close();
		return true;
		
	}

	@Override
	public Employee getAccount(int empId) {
		Session sess=HibernateUtils.getSessionFactory().openSession();
		Employee e=(in.harsh.entity.Employee)sess.get(in.harsh.entity.Employee.class,empId);
		return e;
	}

	@Override
	public boolean closeAccount(int empId) {
		Session sess=HibernateUtils.getSessionFactory().openSession();
		Transaction tx=sess.beginTransaction();
		Employee e=getAccount(empId);
		if(e==null)
		{
			tx.commit();
			return false;
		}
		sess.delete(e);
		tx.commit();
		sess.close();
		return true;
		
	}

	@Override
	public boolean updateAccount(int id, char tr, int amt) throws InSufficientFundsException {
		Session sess=HibernateUtils.getSessionFactory().openSession();
		Transaction tx=sess.beginTransaction();
		Employee e=getAccount(id);
		if(e==null)
		{
			tx.commit();
			return false;
		}

		if(tr=='w')
		{
			if(e.getEmpBal()<amt)
			{
				tx.commit();
				throw new InSufficientFundsException("Balance Too Low");
			}
			e.setEmpBal(e.getEmpBal()-amt);
		
		}
		else
			e.setEmpBal(e.getEmpBal()+amt);
			sess.update(e);
			tx.commit();
		sess.close();
		
	
		return true;
}
	@Override
	public void closeResources() {
		
		
	}

	
	
}

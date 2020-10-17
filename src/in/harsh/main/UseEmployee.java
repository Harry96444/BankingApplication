package in.harsh.main;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.harsh.Dao.EmployeeDao;
import in.harsh.Dao.EmployeeDaoImpl;
import in.harsh.entity.Employee;
import in.harsh.exception.InSufficientFundsException;

public class UseEmployee {

	public static void main(String[] args) {
		
		Configuration cfg=new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session sess=null;
		Scanner sc=new Scanner(System.in);
		
		int id,bal,choice;
		boolean res;
		Employee e=null;
		EmployeeDao dao=new EmployeeDaoImpl();
		
		do {
System.out.println("1.create account\n2.Get account Details\n3.WithDraw Amount\n4.Desposit amount\n5.Close Account\n6.Quit");
System.out.println("=====================================");
System.out.println("Enter your Choice:");
System.out.println("====================================");
choice=sc.nextInt();
switch(choice)
{
case 1:
	
	 e=new Employee();
	try
	{
		
		System.out.println("Enter Emp id");
		e.setEmpId(sc.nextInt());
		System.out.println("Enter emp name");
		e.setEmpName(sc.next());
		System.out.println("ENter emp bal");
		e.setEmpBal(sc.nextInt());
		res=dao.createAccount(e);
		if(res)
		{
			System.out.println("Account Created\n");
		}	
	}catch(Exception ex)
	{
		System.out.println("CAnnot Create Account");
		ex.printStackTrace();
	}
	break;
	
case 2:
	
	
	System.out.println("Enter Employee id:");
	id=sc.nextInt();
	
	try {
		
	    e=dao.getAccount(id);
		if(e==null)
		{
			System.out.println("Cannot get the Account");
		}
		else
		{
			System.out.println("Employee "+e);
		}
	}catch(Exception ex)
	{
		System.out.println("Cannnot read the Account");
		ex.printStackTrace();
	}
	break;

	
case 3:
	
	System.out.println("Enter Emp ID:");
	id=sc.nextInt();
	System.out.println("Enter Balance to withdraw");
	bal=sc.nextInt();
	
	
	try {
		
		res=dao.updateAccount(id,'w',bal);
		if(res==true)
		{
			System.out.println("Account id updated");
		}
		else
		{
			System.out.println("Cannot Update the Account");
		}
	}catch(InSufficientFundsException ex)
	{
		System.out.println("Cannot withdraw from the Account");
		ex.printStackTrace();
	}
	catch(Exception ex)
	{
		System.out.println("Cannot read the Account");
		ex.printStackTrace();
	}
break;
	
case 4:
	
	System.out.println("Enter Emp ID:");
	id=sc.nextInt();
	System.out.println("Enter  BAlance to Deposit");
	bal=sc.nextInt();
	
	
	try {
		
		res=dao.updateAccount(id,'d',bal);
		if(res==true)
		{
			System.out.println("Account id updated");
		}
		else
		{
			System.out.println("Cannot Update the Account");
		}
	}
	catch(Exception ex)
	{
		System.out.println("Cannot read the Account");
		ex.printStackTrace();
	}
	break;
	
	
case 5:
	
	System.out.println("Enter Emp ID:");
	id=sc.nextInt();
	
	try {
		
		res=dao.closeAccount(id);
		if(res==true)
		{
			System.out.println("Account Closed ");
		}
		else
		{
			System.out.println("Cannot Close the Account");
		}
	}
	catch(Exception ex)
	{
		System.out.println("Cannot read the Account");
		ex.printStackTrace();
	}
	break;
	
	
case 6:
	
	System.out.println("Thank You!");
	dao.closeResources();
	System.exit(0);
	
default:
	System.out.println("Please Enter COrrect Choice");
}
		
  }while(true);
		
}


}

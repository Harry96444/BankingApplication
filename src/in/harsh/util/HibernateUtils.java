package in.harsh.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils  {

	private static SessionFactory sf=null;
	
	static {
		
		try {
			Configuration cfg=new Configuration();
			cfg.configure("resources/hibernate.cfg.xml");
			sf=cfg.buildSessionFactory();
		}catch(ExceptionInInitializerError e)
		{
			System.out.println("Error in HibernateUtils");
			throw new ExceptionInInitializerError("Error in loading the configuration file");
		}
	}	
		public static SessionFactory getSessionFactory()
		{
			return sf;
		}
		public static void closeSessionFactory()
		{
			if(sf!=null)
			{
				sf.close();
			}
		}
	}
	


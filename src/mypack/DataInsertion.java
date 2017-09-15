package mypack;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class DataInsertion {

	public static void main(String[] args) {
		new DataInsertion().insertInfo();
		//new DataInsertion().updateInfo();
		//new DataInsertion().getInfo();
		//new DataInsertion().deleteInfo();

	}
	public void insertInfo(){
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		DataProvider dp = new DataProvider();
		dp.setUser_id(1);
		dp.setUser_name("Prashanth");
		dp.setUser_address("Dallas, TX");
		
		Transaction tran = session.beginTransaction();
		session.save(dp);
		System.out.println("Object saved successfully");
		tran.commit();
		session.close();
		sf.close();
	}
	public void deleteInfo(){
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tr = session.beginTransaction();
		//541 is the primary key
		Object ob = session.load(DataProvider.class, new Integer(1));
		session.delete(ob);
		System.out.println("Record Deleted");
		tr.commit();
		session.close();
		sf.close();
	}
	
	public void getInfo(){
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Object ob = session.load(DataProvider.class, new Integer(1));
		DataProvider dp = (DataProvider) ob;
		System.out.println("Name : "+dp.getUser_name());
	}
	
	//Updates the information
	public void updateInfo(){
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tr = session.beginTransaction();
		Object ob = session.load(DataProvider.class, new Integer(1));
		DataProvider dp = (DataProvider) ob;
		dp.setUser_name("Anurag");
		dp.setUser_address("Telangana, India");
		
		System.out.println("Data is Updated successfully");
		tr.commit();
		session.close();
		sf.close();
		
	}

}

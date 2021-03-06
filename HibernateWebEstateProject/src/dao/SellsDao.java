package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import config.HibernateUtil;

import bean.Sells;

public class SellsDao {

	public static int save(Sells u){
		int status = 0;
		
		try{
			SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
			Session session = sessionFactory.openSession(); 
			session.beginTransaction();
			session.save(u);
			session.getTransaction().commit();
			session.close();
			status = 1;
		}catch(Exception e){
			System.out.println(e);
		}
		
		return status;
	}
	
}

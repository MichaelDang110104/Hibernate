package daos;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import pojos.Account;

public class AccountDAO {
	SessionFactory sessionFactory = null;
	Configuration cf = null;
	public AccountDAO(String configuartionFile) {
		cf = new Configuration();
		cf = cf.configure(configuartionFile);
		sessionFactory = cf.buildSessionFactory();
	}
	
	public void save(Account Account) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(Account);
			t.commit();
			System.out.println("Save Account successfully !");
		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
			t.rollback();
		}finally {
			session.close();
		}
	}
	
	public void update(Account Account) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.clear();
			session.update(Account);
			t.commit();
			System.out.println("Update Account successfully !");
		} catch (Exception e) {
			t.rollback();
			System.out.println("Error: " + e.getMessage());
		} finally {
			session.close();
		}
	}

	public void delete(int id) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			Account Account = session.get(Account.class, id);
			session.delete(Account);
			t.commit();
			System.out.println("Delete Account successfully !");
		} catch (Exception e) {
			t.rollback();
			System.out.println("Error: " + e.getMessage());
		} finally {
			session.close();
		}
	}
	
	public List<Account> getAll() {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			List<Account> ds = session.createQuery("Select a From Account a", Account.class).list();
			return ds;
		} catch (Exception e) {
			t.rollback();
			System.out.println("Error: " + e.getMessage());
			return null;
		} finally {
			session.close();
		}
	}

	public Account findByID(int id) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			Account account = session.get(Account.class, id);
			return account;
		} catch (Exception e) {
			t.rollback();
			System.out.println("Error: " + e.getMessage());
			return null;
		} finally {
			session.close();
		}
	}
	
}


package daos;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import pojos.Account;
import pojos.Customer;
import services.AccountService;
import services.CustomerService;
import services.IAccountService;
import services.ICustomerService;

public class CustomerDAO {
	SessionFactory sessionFactory = null;
	Configuration cf = null;
	
	public CustomerDAO(String configuartionFile) {
		cf = new Configuration();
		cf = cf.configure(configuartionFile);
		sessionFactory = cf.buildSessionFactory();
	}

	public void save(Customer customer) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.clear();
			session.save(customer);
			t.commit();
			System.out.println("Save customer successfully !");
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			t.rollback();
		} finally {
			session.close();
		}
	}

	public void update(Customer customer) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.clear();
			if(session.contains(customer)) {
				session.evict(customer);
			}
			Account account = customer.getAccount();
			if(account != null) {
				session.update(account);
			}
			session.update(customer);
			t.commit();
			System.out.println("Update customer successfully !");
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			t.rollback();
		} finally {
			session.close();
		}
	}

	public void delete(int id) {
	    Session session = sessionFactory.openSession();
	    Transaction t = session.beginTransaction();
	    try {
	    	session.clear();
	        Customer customer = session.get(Customer.class, id);
	        if (customer != null) {
	            session.delete(customer);
	        }
	        t.commit();
	        System.out.println("Deleted customer successfully!");
	    } catch (Exception e) {
	        System.out.println("Error: " + e.getMessage());
	        t.rollback();
	    } finally {
	        session.close();
	    }
	}


	public List<Customer> getAll() {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			List<Customer> ds = session.createQuery("Select c from Customer c", Customer.class).list();
			return ds;
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			t.rollback();
			return null;
		} finally {
			session.clear();
			session.close();
		}
	}
	
	public Customer findByID(int id) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			Customer customer = session.get(Customer.class, id);
			Hibernate.initialize(customer.getCarRentalList());
	        Hibernate.initialize(customer.getReviewList());
	        t.commit();
			return customer;
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			t.rollback();
			return null;
		} finally {
			session.clear();
			session.close();
		}
	}
	
	public Customer login(String email, String password) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		Customer customer = null;
		try {
			String hbl = "Select user from Customer user where email =: email and password =: password";
			customer = session.createQuery(hbl,Customer.class).setParameter("email", email).setParameter("password", password).uniqueResult();
			return customer;
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			t.rollback();
			return null;
		} finally {
			session.clear();
			session.close();
		}
	}

}

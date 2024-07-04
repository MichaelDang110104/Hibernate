package daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import pojos.CarProducer;

public class CarProducerDAO {
	SessionFactory sessionFactory = null;
	Configuration cf = null;

	public CarProducerDAO(String configuartionFile) {
		cf = new Configuration();
		cf = cf.configure(configuartionFile);
		sessionFactory = cf.buildSessionFactory();
	}

	public void save(CarProducer carProducer) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(carProducer);
			t.commit();
			System.out.println("Save CarProducer successfully !");
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			t.rollback();
		} finally {
			session.close();
		}
	}

	public void update(CarProducer carProducer) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.clear();
			session.update(carProducer);
			t.commit();
			System.out.println("Update CarProducer successfully !");
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
			CarProducer carProducer = session.get(CarProducer.class, id);
			session.delete(carProducer);
			t.commit();
			System.out.println("Delete CarProducer successfully !");
		} catch (Exception e) {
			t.rollback();
			System.out.println("Error: " + e.getMessage());
		} finally {
			session.close();
		}
	}

	public List<CarProducer> getAll() {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			List<CarProducer> ds = session.createQuery("Select cp From CarProducer cp", CarProducer.class).list();
			return ds;
		} catch (Exception e) {
			t.rollback();
			System.out.println("Error: " + e.getMessage());
			return null;
		} finally {
			session.close();
		}
	}

	public CarProducer findByID(int id) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			CarProducer carProducer = session.get(CarProducer.class, id);
			return carProducer;
		} catch (Exception e) {
			t.rollback();
			System.out.println("Error: " + e.getMessage());
			return null;
		} finally {
			session.close();
		}
	}
}

package daos;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import pojos.Car;
import pojos.CarProducer;

public class CarDAO {
	SessionFactory sessionFactory = null;
	Configuration cf = null;

	public CarDAO(String configuartionFile) {
		cf = new Configuration();
		cf = cf.configure(configuartionFile);
		sessionFactory = cf.buildSessionFactory();
	}

	public void save(Car car) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(car);
			t.commit();
			System.out.println("Save Car successfully !");
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			t.rollback();
		} finally {
			session.close();
		}
	}

	public void update(Car car) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.clear();
			session.update(car);
			t.commit();
			System.out.println("Update Car successfully !");
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
			Car car = session.get(Car.class, id);
			if(car != null) {
				CarProducer carProducer = car.getProducer();
				if(carProducer != null) {
					Set<Car> ds = carProducer.getCar();
				ds.remove(car);session.update(carProducer);
				}
				session.remove(car);
			}
			
			t.commit();
			System.out.println("Delete Car successfully !");
		} catch (Exception e) {
			t.rollback();
			System.out.println("Error: " + e.getMessage());
		} finally {
			session.close();
		}
	}

	public List<Car> getAll() {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			List<Car> ds = session.createQuery("Select c From Car c", Car.class).list();
			return ds;
		} catch (Exception e) {
			t.rollback();
			System.out.println("Error: " + e.getMessage());
			return null;
		} finally {
			session.close();
		}
	}

	public Car findByID(int id) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			Car car = session.get(Car.class, id);
			return car;
		} catch (Exception e) {
			t.rollback();
			System.out.println("Error: " + e.getMessage());
			return null;
		} finally {
			session.close();
		}
	}
}

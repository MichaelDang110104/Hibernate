package daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import pojos.CarRental;
import pojos.CarRentalKey;

public class CarRentalDAO {
	SessionFactory sessionFactory = null;
	Configuration cf = null;
	
	public CarRentalDAO() {
		// TODO Auto-generated constructor stub
	}

	public CarRentalDAO(String configuartionFile) {
		cf = new Configuration();
		cf = cf.configure(configuartionFile);
		sessionFactory = cf.buildSessionFactory();
	}
	
	public void save(CarRental carRental) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(carRental);
			t.commit();
			System.out.println("Save CarRental successfully !");
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			t.rollback();
		} finally {
			session.close();
		}
	}
	
	public void update(CarRental carRental) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.clear();
			session.update(carRental);
			t.commit();
			System.out.println("Update CarRental successfully !");
		} catch (Exception e) {
			t.rollback();
			System.out.println("Error: " + e.getMessage());
		} finally {
			session.close();
		}
	}
	
	public void delete(CarRentalKey id) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
            t = session.beginTransaction();
            CarRental carRental = session.get(CarRental.class, id);
            if (carRental != null) {
                session.delete(carRental);
            }
            t.commit();
        } catch (Exception e) {
            if (t != null) t.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
	}
	
	public List<CarRental> getAll() {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			List<CarRental> ds = session.createQuery("Select cr From CarRental cr", CarRental.class).list();
			return ds;
		} catch (Exception e) {
			t.rollback();
			System.out.println("Error: " + e.getMessage());
			return null;
		} finally {
			session.close();
		}
	}
	
	public CarRental findByID(CarRentalKey id) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			CarRental carRental = session.get(CarRental.class, id);
			return carRental;
		} catch (Exception e) {
			t.rollback();
			System.out.println("Error: " + e.getMessage());
			return null;
		} finally {
			session.close();
		}
	}
}

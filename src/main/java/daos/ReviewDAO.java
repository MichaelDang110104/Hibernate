package daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import pojos.CarRental;
import pojos.CarRentalKey;
import pojos.Review;
import pojos.ReviewKey;

public class ReviewDAO {
	SessionFactory sessionFactory = null;
	Configuration cf = null;
	
	public ReviewDAO(String configuartionFile) {
		cf = new Configuration();
		cf = cf.configure(configuartionFile);
		sessionFactory = cf.buildSessionFactory();
	}
	
	public void save(Review review) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(review);
			t.commit();
			System.out.println("Save review successfully !");
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			t.rollback();
		} finally {
			session.close();
		}
	}
	
	public void update(Review review) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.clear();
			session.update(review);
			t.commit();
			System.out.println("Update review successfully !");
		} catch (Exception e) {
			t.rollback();
			System.out.println("Error: " + e.getMessage());
		} finally {
			session.close();
		}
	}
	
	public void delete(ReviewKey id) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
            t = session.beginTransaction();
            Review carRental = session.get(Review.class, id);
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
	
	public List<Review> getAll() {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			List<Review> ds = session.createQuery("Select r From Review r", Review.class).list();
			return ds;
		} catch (Exception e) {
			t.rollback();
			System.out.println("Error: " + e.getMessage());
			return null;
		} finally {
			session.close();
		}
	}
	
	public Review findByID(ReviewKey id) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			Review carRental = session.get(Review.class, id);
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

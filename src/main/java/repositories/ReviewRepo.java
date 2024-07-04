package repositories;

import java.util.List;

import daos.CarRentalDAO;
import daos.ReviewDAO;
import pojos.CarRental;
import pojos.CarRentalKey;
import pojos.Review;
import pojos.ReviewKey;

public class ReviewRepo implements IReviewRepo{
	ReviewDAO reviewDAO = null;
	public ReviewRepo(String configurationFile) {
		if(reviewDAO == null) {
			reviewDAO = new ReviewDAO(configurationFile);
		}
	}
	@Override
	public void save(Review review) {
		// TODO Auto-generated method stub
		reviewDAO.save(review);
	}
	@Override
	public void update(Review review) {
		// TODO Auto-generated method stub
		reviewDAO.update(review);

	}
	@Override
	public void delete(ReviewKey id) {
		// TODO Auto-generated method stub
		reviewDAO.delete(id);
	}
	@Override
	public List<Review> getAll() {
		// TODO Auto-generated method stub
		return reviewDAO.getAll();
	}
	@Override
	public Review findByID(ReviewKey id) {
		// TODO Auto-generated method stub
		return reviewDAO.findByID(id);
	}
	
}

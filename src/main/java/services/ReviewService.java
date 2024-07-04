package services;

import java.util.List;

import pojos.Review;
import pojos.ReviewKey;
import repositories.IReviewRepo;
import repositories.ReviewRepo;

public class ReviewService implements IReviewService{
	IReviewRepo iReviewRepo = null;
	public ReviewService(String configurationFile) {
		if(iReviewRepo == null) {
			iReviewRepo = new ReviewRepo(configurationFile);
		}
	}
	@Override
	public void save(Review review) {
		// TODO Auto-generated method stub
		iReviewRepo.save(review);
	}

	@Override
	public void update(Review review) {
		// TODO Auto-generated method stub
		iReviewRepo.update(review);
	}

	@Override
	public void delete(ReviewKey id) {
		// TODO Auto-generated method stub
		iReviewRepo.delete(id);
	}

	@Override
	public List<Review> getAll() {
		// TODO Auto-generated method stub
		return iReviewRepo.getAll();
	}

	@Override
	public Review findByID(ReviewKey id) {
		// TODO Auto-generated method stub
		return iReviewRepo.findByID(id);
	}

}

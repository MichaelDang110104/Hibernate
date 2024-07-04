package services;

import java.util.List;

import pojos.Review;
import pojos.ReviewKey;


public interface IReviewService {
	public void save(Review review);
	public void update(Review review);
	public void delete(ReviewKey id);
	public List<Review> getAll();
	public Review findByID(ReviewKey id);
}

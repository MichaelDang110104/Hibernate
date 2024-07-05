package pojos;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "REVIEWS")
public class Review {

	@EmbeddedId
	private ReviewKey id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("customerId")
	private Customer customer;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("carId")
	private Car car;

    @Column(name = "ReviewStar", nullable = false)
    private Integer reviewStar;

    @Column(name = "Comment", length = 500)
    private String comment;

    
    
	public ReviewKey getId() {
		return id;
	}

	public void setId(ReviewKey id) {
		this.id = id;
	}
	
	public Review(Customer cus, Car car) {
		this.car = car;
		this.customer = cus;
		this.id = new ReviewKey(cus.getCustomerID(), car.getCarId());
		// TODO Auto-generated constructor stub
	}
	
	public Review() {
		// TODO Auto-generated constructor stub
	}

	public Review(Customer cus, Car car, Integer reviewStar, String comment) {
		this.car = car;
		this.customer = cus;
		this.id = new ReviewKey(cus.getCustomerID(), car.getCarId());
		this.reviewStar = reviewStar;
		this.comment = comment;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Integer getReviewStar() {
		return reviewStar;
	}

	public void setReviewStar(Integer reviewStar) {
		this.reviewStar = reviewStar;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Review [customer=" + customer + ", car=" + car + ", reviewStar=" + reviewStar + ", comment=" + comment
				+ "]";
	}
	
	public int getCustomerId() {
		if(customer != null) {
			return customer.getCustomerID();
		}else {
			return 0;
		}
	}
	
	public int getCarId() {
		if(car != null) {
			return car.getCarId();
		}else {
			return 0;
		}
	}
    
}

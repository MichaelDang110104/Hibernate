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
	private CarRentalKey id;
	
	@ManyToOne
	@MapsId("customerId")
	@JoinColumn(name = "CustomerID", nullable = false)
	private Customer customer;

	@ManyToOne
	@MapsId("carId")
	@JoinColumn(name = "CarID", nullable = false)
	private Car car;

    @Column(name = "ReviewStar", nullable = false)
    private Integer reviewStar;

    @Column(name = "Comment", length = 500)
    private String comment;

    
    
	public CarRentalKey getId() {
		return id;
	}

	public void setId(CarRentalKey id) {
		this.id = id;
	}

	public Review( Integer reviewStar, String comment) {
		super();
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
    
    

}

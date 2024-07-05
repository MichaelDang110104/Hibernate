package pojos;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collector;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CAR_RENTAL")
public class CarRental {
	
	@EmbeddedId
    private CarRentalKey id;

    @ManyToOne
    @MapsId("carId")
    @JoinColumn(name = "CarID")
    private Car car;

    @ManyToOne
    @MapsId("customerId")
    @JoinColumn(name = "CustomerID")
    private Customer customer;

	@Column(name = "PickupDate", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date pickupDate;

	@Column(name = "ReturnDate")
	@Temporal(TemporalType.DATE)
	private Date returnDate;

	@Column(name = "RentPrice", nullable = false)
	private double rentPrice;

	@Column(name = "Status", nullable = false)
	private String status;
	
	public CarRental(Customer cus, Car car) {
		this.car = car;
		this.customer = cus;
		this.id = new CarRentalKey(cus.getCustomerID(), car.getCarId());
		// TODO Auto-generated constructor stub
	}
	
	public int getCustomerID() {
		if(customer != null) {
			int customerID = customer.getCustomerID();
			return customerID;
		}
		return 0;
	}

	public int getCarID() {
		if(customer != null) {
			int carID = car.getCarId();
			return carID;
		}
		return 0;
	}



	public CarRental(Customer cus, Car car, Date pickupDate, Date returnDate, double rentPrice, String status) {
		this.car = car;
		this.customer = cus;
		this.id = new CarRentalKey(cus.getCustomerID(), car.getCarId());
		this.pickupDate = pickupDate;
		this.returnDate = returnDate;
		this.rentPrice = rentPrice;
		this.status = status;
	}
	
	public CarRental() {
        // Default constructor required by Hibernate
    }
	

	public CarRental(CarRentalKey id, Car car, Customer customer, Date pickupDate, Date returnDate, double rentPrice,
			String status) {
		super();
		this.id = id;
		this.car = car;
		this.customer = customer;
		this.pickupDate = pickupDate;
		this.returnDate = returnDate;
		this.rentPrice = rentPrice;
		this.status = status;
	}

	public CarRentalKey getId() {
		return id;
	}

	public void setId(CarRentalKey id) {
		this.id = id;
	}

	public CarRental(Date pickupDate, Date returnDate, double rentPrice, String status) {
		super();
		this.pickupDate = pickupDate;
		this.returnDate = returnDate;
		this.rentPrice = rentPrice;
		this.status = status;
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

	public Date getPickupDate() {
		return pickupDate;
	}

	public void setPickupDate(Date pickupDate) {
		this.pickupDate = pickupDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public double getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(double rentPrice) {
		this.rentPrice = rentPrice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCarName() {
		if(this.car != null)
			return car.getCarName();
		return "";
	}
	
	public Integer getStars() {
		if(this.car != null) {
			if(!this.car.getCarReviewList().isEmpty()) {
	            List<Review> listReview = car.getCarReviewList().stream().toList();
				AtomicInteger star = new AtomicInteger(0);
				listReview.forEach(row -> {
					if(row.getCustomer().getCustomerID() == this.customer.getCustomerID()) {
						star.set(row.getReviewStar());
					}
				});
				return star.get();
			}
			return 0;
		}
		return 0;
	}
	
	public String getReview() {
		if(this.car != null) {
			if(!this.car.getCarReviewList().isEmpty()) {
	            List<Review> listReview = car.getCarReviewList().stream().toList();
				AtomicReference<String> star = new AtomicReference<String>("");
				listReview.forEach(row -> {
					if(row.getCustomer().getCustomerID() == this.customer.getCustomerID()) {
						star.set(row.getComment());
					}
				});
				return star.get();
			}
			return "";
		}
		return "";
	}
}

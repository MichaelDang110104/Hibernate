package pojos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
	@MapsId("customerId")
	@JoinColumn(name = "CustomerID", nullable = false)
	private Customer customer;

	@ManyToOne
	@MapsId("carId")
	@JoinColumn(name = "CarID", nullable = false)
	private Car car;

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

	@Override
	public String toString() {
		return "CarRental [customer=" + customer + ", car=" + car + ", pickupDate=" + pickupDate + ", returnDate="
				+ returnDate + ", rentPrice=" + rentPrice + ", status=" + status + "]";
	}

}

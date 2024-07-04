package pojos;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CARS")
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CarID")
	private int carId;

	@Column(name = "CarName", nullable = false)
	private String carName;

	@Column(name = "CarModelYear", nullable = false)
	private Integer carModelYear;

	@Column(name = "Color", nullable = false)
	private String color;

	@Column(name = "Capacity", nullable = false)
	private Integer capacity;

	@Column(name = "Description")
	private String description;

	@Column(name = "ImportDate", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date importDate;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ProducerID")
	private CarProducer producer;

	@Column(name = "RentPrice", nullable = false)
	private double rentPrice;

	@Column(name = "Status", nullable = false)
	private String status;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "CarID")
	private Set<CarRental> carRentalList = new HashSet<CarRental>();

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "CarID")
	private Set<Review> carReviewList = new HashSet<Review>();

	public int getProducerId() {

		if (producer != null) {
			int producerID = producer.getProducerId();
			return producerID;
		}
		return 0;
	}

	public Car() {
		// TODO Auto-generated constructor stub
	}

	public Set<CarRental> getCarRentalList() {
		return carRentalList;
	}

	public void setCarRentalList(Set<CarRental> carRentalList) {
		this.carRentalList = carRentalList;
	}

	public Set<Review> getCarReviewList() {
		return carReviewList;
	}

	public void setCarReviewList(Set<Review> carReviewList) {
		this.carReviewList = carReviewList;
	}



	public Car(String carName, Integer carModelYear, String color, Integer capacity, String description,
			Date importDate, CarProducer producer, double rentPrice, String status) {
		super();
		this.carName = carName;
		this.carModelYear = carModelYear;
		this.color = color;
		this.capacity = capacity;
		this.description = description;
		this.importDate = importDate;
		this.producer = producer;
		this.rentPrice = rentPrice;
		this.status = status;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public Integer getCarModelYear() {
		return carModelYear;
	}

	public void setCarModelYear(Integer carModelYear) {
		this.carModelYear = carModelYear;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getImportDate() {
		return importDate;
	}

	public void setImportDate(Date importDate) {
		this.importDate = importDate;
	}

	public CarProducer getProducer() {
		return producer;
	}

	public void setProducer(CarProducer producer) {
		this.producer = producer;
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
		return "Car [carId=" + carId + ", carName=" + carName + ", carModelYear=" + carModelYear + ", color=" + color
				+ ", capacity=" + capacity + ", description=" + description + ", importDate=" + importDate
				+ ", producer=" + producer + ", rentPrice=" + rentPrice + ", status=" + status + "]";
	}

}

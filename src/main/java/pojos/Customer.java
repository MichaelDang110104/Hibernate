package pojos;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
@Entity
@Table(name = "CUSTOMERS")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CustomerID",updatable = true)
	private int customerID;

	@Column(name = "CustomerName",updatable = true)
	private String customerName;

	@Column(name = "Mobile" , length = 10,updatable = true)
	private String mobile;

	@Column(name = "Birthdate",updatable = true)
	@Temporal(TemporalType.DATE)
	private Date birthday;

	@Column(name = "IdentityCard",updatable = true)
	private String identityCard;

	@Column(name = "LicenceNumber",updatable = true)
	private String licenceNumber;

	@Column(name = "LicenceDate",updatable = true)
	@Temporal(TemporalType.DATE)
	private Date licenceDate;

	@Column(name = "Email",updatable = true)
	private String email;

	@Column(name = "Password",updatable = true)
	private String password;

	@OneToOne(fetch = FetchType.EAGER, cascade = javax.persistence.CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "AccountID")
	private Account account;
	
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "customer")
	private Set<Review> reviewList = new HashSet<Review>();
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "customer")
	private Set<CarRental> carRentalList = new HashSet<CarRental>();
	
	public int getAccountID() {
		if(account!= null) {
			int accountID = account.getAccountID();
			return accountID;
		}
		return 0;
	}

	public Set<Review> getReviewList() {
		return reviewList;
	}

	public void setReviewList(Set<Review> reviewList) {
		this.reviewList = reviewList;
	}

	public Set<CarRental> getCarRentalList() {
		return carRentalList;
	}

	public void setCarRentalList(Set<CarRental> carRentalList) {
		this.carRentalList = carRentalList;
	}
	
	public void removeCarCarRental(Car car) {
		for(Iterator<CarRental> iter = carRentalList.iterator(); iter.hasNext(); ) {
			CarRental carRental = iter.next();
			if(carRental.getCustomer().customerID == this.customerID && carRental.getCar().getCarId() == car.getCarId()) {
				iter.remove();
				carRental.getCar().removeCarRental(carRental);;
				carRental.setCar(null);
				carRental.setCustomer(null);
			}
		}
	}
		
	public void addCarRental(Car car, Date pickupDate, Date returnDate, double rentPrice, String status) {
		CarRental carRental = new CarRental(this, car, pickupDate, returnDate, rentPrice, status);
		carRentalList.add(carRental);
		car.getCarRentalList().add(carRental);
	}
	
	public void removeCarReview(Car car) {
		for(Iterator<CarRental> iter = carRentalList.iterator(); iter.hasNext(); ) {
			CarRental carRental = iter.next();
			if(carRental.getCustomer().customerID == this.customerID && carRental.getCar().getCarId() == car.getCarId()) {
				iter.remove();
				carRental.getCar().getCarRentalList().remove(carRental);
				carRental.setCar(null);
				carRental.setCustomer(null);
			}
		}
	}
		
	public void addReview(Car car, Integer reviewStar, String comment) {
		Review review = new Review(this, car, reviewStar, comment);
		reviewList.add(review);
		car.getCarReviewList().add(review);
	}

	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	public Customer(String customerName, String mobile, Date birthday, String identityCard, String licenceNumber,
			Date licenceDate, String email, String password, Account account) {
		super();
		this.customerName = customerName;
		this.mobile = mobile;
		this.birthday = birthday;
		this.identityCard = identityCard;
		this.licenceNumber = licenceNumber;
		this.licenceDate = licenceDate;
		this.email = email;
		this.password = password;
		this.account = account;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getIdentityCard() {
		return identityCard;
	}

	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}

	public String getLicenceNumber() {
		return licenceNumber;
	}

	public void setLicenceNumber(String licenceNumber) {
		this.licenceNumber = licenceNumber;
	}

	public Date getLicenceDate() {
		return licenceDate;
	}

	public void setLicenceDate(Date licenceDate) {
		this.licenceDate = licenceDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

//	@Override
//	public String toString() {
//		return "Customer [customerID=" + customerID + ", customerName=" + customerName + ", mobile=" + mobile
//				+ ", birthday=" + birthday + ", identityCard=" + identityCard + ", licenceNumber=" + licenceNumber
//				+ ", licenceDate=" + licenceDate + ", email=" + email + ", password=" + password + "," + "]";
//	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(account, birthday, carRentalList, customerID, customerName, email, identityCard,
//				licenceDate, licenceNumber, mobile, password, reviewList);
//	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(account, other.account) && Objects.equals(birthday, other.birthday)
				&& Objects.equals(carRentalList, other.carRentalList) && customerID == other.customerID
				&& Objects.equals(customerName, other.customerName) && Objects.equals(email, other.email)
				&& Objects.equals(identityCard, other.identityCard) && Objects.equals(licenceDate, other.licenceDate)
				&& Objects.equals(licenceNumber, other.licenceNumber) && Objects.equals(mobile, other.mobile)
				&& Objects.equals(password, other.password) && Objects.equals(reviewList, other.reviewList);
	}
	
	

}

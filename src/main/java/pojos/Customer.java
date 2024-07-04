package pojos;

import java.util.Date;
import java.util.HashSet;
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

	@OneToOne(cascade = javax.persistence.CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name = "AccountID")
	private Account account;
	
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "CustomerID")
	private Set<Review> reviewList = new HashSet<Review>();
	
	@OneToMany(fetch =  FetchType.EAGER)
	@JoinColumn(name = "CustomerID")
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

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", customerName=" + customerName + ", mobile=" + mobile
				+ ", birthday=" + birthday + ", identityCard=" + identityCard + ", licenceNumber=" + licenceNumber
				+ ", licenceDate=" + licenceDate + ", email=" + email + ", password=" + password + "," + "]";
	}

}

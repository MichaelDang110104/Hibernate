package pojos;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CAR_PRODUCERS")
public class CarProducer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ProducerID")
	private int producerId;

	@Column(name = "ProducerName", nullable = false)
	private String producerName;

	@Column(name = "Address", nullable = false)
	private String address;

	@Column(name = "Country", nullable = false)
	private String country;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "ProducerID")
	private Set<Car> car = new HashSet<Car>();

	public CarProducer() {
		// TODO Auto-generated constructor stub
	}
	public CarProducer(String producerName, String address, String country) {
		super();
		this.producerName = producerName;
		this.address = address;
		this.country = country;
	}

	public int getProducerId() {
		return producerId;
	}

	public void setProducerId(int producerId) {
		this.producerId = producerId;
	}

	public String getProducerName() {
		return producerName;
	}

	public void setProducerName(String producerName) {
		this.producerName = producerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Set<Car> getCar() {
		return car;
	}

	public void setCar(Set<Car> car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "CarProducer [producerId=" + producerId + ", producerName=" + producerName + ", address=" + address
				+ ", country=" + country + ", car=" + car + "]";
	}

}

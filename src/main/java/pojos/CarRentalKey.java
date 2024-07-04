package pojos;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CarRentalKey implements Serializable{

	@Column(name = "CustomerID")
	private int customerId;
	
	@Column(name = "CarID")
	private int carId;
	
	public CarRentalKey() {
		// TODO Auto-generated constructor stub
	}

	public CarRentalKey(int customerId, int carId) {
		this.customerId = customerId;
		this.carId = carId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(carId, customerId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarRentalKey other = (CarRentalKey) obj;
		return carId == other.carId && customerId == other.customerId;
	}

	@Override
	public String toString() {
		return "CarRentalKey [customerId=" + customerId + ", carId=" + carId + "]";
	}
	
	
}

package pojos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ReviewKey implements Serializable{

	@Column(name = "CustomerID")
	private int customerId;
	
	@Column(name = "CarID")
	private int carId;
	
	public ReviewKey() {
		// TODO Auto-generated constructor stub
	}
	
	
	public ReviewKey(int customerId, int carId) {
		super();
		this.customerId = customerId;
		this.carId = carId;
	}



	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
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
	
	
	
	
}

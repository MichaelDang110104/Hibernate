package repositories;

import java.util.List;

import pojos.Car;
import pojos.CarRental;
import pojos.CarRentalKey;

public interface ICarRentalRepo {
	public void save(CarRental carRental);
	public void update(CarRental carRental);
	public void delete(CarRentalKey id);
	public List<CarRental> getAll();
	public CarRental findByID(CarRentalKey id);
}

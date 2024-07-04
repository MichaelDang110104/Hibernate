package repositories;

import java.util.List;

import daos.CarProducerDAO;
import daos.CarRentalDAO;
import pojos.Car;
import pojos.CarRental;
import pojos.CarRentalKey;

public class CarRentalRepo implements ICarRentalRepo{
	
	
	CarRentalDAO carRentalDAO = null;
	public CarRentalRepo(String configurationFile) {
		if(carRentalDAO == null) {
			carRentalDAO = new CarRentalDAO(configurationFile);
		}
	}
	

	@Override
	public void save(CarRental carRental) {
		carRentalDAO.save(carRental); 
	}

	@Override
	public void update(CarRental carRental) {
		carRentalDAO.update(carRental);
	}

	@Override
	public void delete(CarRentalKey id) {
		carRentalDAO.delete(id);
	}

	@Override
	public List<CarRental> getAll() {
		return carRentalDAO.getAll();
	}

	@Override
	public CarRental findByID(CarRentalKey id) {
		return carRentalDAO.findByID(id);
	}

}

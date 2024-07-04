package services;

import java.util.List;

import daos.CarRentalDAO;
import pojos.CarRental;
import pojos.CarRentalKey;
import repositories.CarRentalRepo;
import repositories.ICarRentalRepo;

public class CarRentalService implements ICarRentalService{
	ICarRentalRepo iCarRentalRepo = null;
	public CarRentalService(String configurationFile) {
		if(iCarRentalRepo == null) {
			iCarRentalRepo = new CarRentalRepo(configurationFile);
		}
	}
	@Override
	public void save(CarRental carRental) {
		// TODO Auto-generated method stub
		iCarRentalRepo.save(carRental);
	}

	@Override
	public void update(CarRental carRental) {
		// TODO Auto-generated method stub
		iCarRentalRepo.update(carRental);
	}

	@Override
	public void delete(CarRentalKey id) {
		// TODO Auto-generated method stub
		iCarRentalRepo.delete(id);
	}

	@Override
	public List<CarRental> getAll() {
		// TODO Auto-generated method stub
		return iCarRentalRepo.getAll();
	}

	@Override
	public CarRental findByID(CarRentalKey id) {
		// TODO Auto-generated method stub
		return iCarRentalRepo.findByID(id);
	}

}

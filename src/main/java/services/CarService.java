package services;

import java.util.List;

import pojos.Car;
import repositories.CarRepo;
import repositories.ICarRepo;

public class CarService implements ICarService{
	ICarRepo iCarRepo = null;
	public CarService(String configurationFile) {
		if(iCarRepo == null) {
			iCarRepo = new CarRepo(configurationFile);
		}
	}
	@Override
	public void save(Car car) {
		// TODO Auto-generated method stub
		iCarRepo.save(car);
	}

	@Override
	public void update(Car car) {
		// TODO Auto-generated method stub
		iCarRepo.update(car);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		iCarRepo.delete(id);
	}

	@Override
	public List<Car> getAll() {
		// TODO Auto-generated method stub
		return iCarRepo.getAll();
	}

	@Override
	public Car findByID(int id) {
		// TODO Auto-generated method stub
		return iCarRepo.findByID(id);
	}

}

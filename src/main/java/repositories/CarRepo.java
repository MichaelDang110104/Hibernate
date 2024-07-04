package repositories;

import java.util.List;

import daos.CarDAO;
import pojos.Car;

public class CarRepo implements ICarRepo{
	CarDAO carDAO = null;
	public CarRepo(String configurationFile) {
		carDAO = new CarDAO(configurationFile);
	}
	
	@Override
	public void save(Car car) {
		// TODO Auto-generated method stub
		carDAO.save(car);
	}

	@Override
	public void update(Car car) {
		// TODO Auto-generated method stub
		carDAO.update(car);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		carDAO.delete(id);
	}

	@Override
	public List<Car> getAll() {
		// TODO Auto-generated method stub
		return carDAO.getAll();
	}

	@Override
	public Car findByID(int id) {
		// TODO Auto-generated method stub
		return carDAO.findByID(id);
	}

}

package repositories;

import java.util.List;

import pojos.Car;

public interface ICarRepo {
	public void save(Car car);
	public void update(Car car);
	public void delete(int id);
	public List<Car> getAll();
	public Car findByID(int id);
}

package repositories;

import java.util.List;

import pojos.CarProducer;

public interface ICarProducerRepo {
	public void save(CarProducer carProducer);
	public void update(CarProducer carProducer);
	public void delete(int id);
	public List<CarProducer> getAll();
	public CarProducer findByID(int id);
}

package repositories;

import java.util.List;

import daos.CarProducerDAO;
import pojos.CarProducer;

public class CarProducerRepo implements ICarProducerRepo{
	CarProducerDAO carProducerDAO = null;
	public CarProducerRepo(String configurationFile) {
		if(carProducerDAO == null) {
			carProducerDAO = new CarProducerDAO(configurationFile);
		}
	}
	
	@Override
	public void save(CarProducer carProducer) {
		// TODO Auto-generated method stub
		carProducerDAO.save(carProducer);
	}

	@Override
	public void update(CarProducer carProducer) {
		// TODO Auto-generated method stub
		carProducerDAO.update(carProducer);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		carProducerDAO.delete(id);
	}

	@Override
	public List<CarProducer> getAll() {
		// TODO Auto-generated method stub
		return carProducerDAO.getAll();
	}

	@Override
	public CarProducer findByID(int id) {
		// TODO Auto-generated method stub
		return carProducerDAO.findByID(id);
	}

}

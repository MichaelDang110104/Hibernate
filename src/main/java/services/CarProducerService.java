package services;

import java.util.List;

import pojos.CarProducer;
import repositories.CarProducerRepo;
import repositories.ICarProducerRepo;

public class CarProducerService implements ICarProducerService{
	ICarProducerRepo iCarProducerRepo = null;
	public CarProducerService(String configurationFile) {
		if(iCarProducerRepo == null) {
			iCarProducerRepo = new CarProducerRepo(configurationFile);
		}
	}
	@Override
	public void save(CarProducer carProducer) {
		// TODO Auto-generated method stub
		iCarProducerRepo.save(carProducer);
	}

	@Override
	public void update(CarProducer carProducer) {
		// TODO Auto-generated method stub
		iCarProducerRepo.update(carProducer);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		iCarProducerRepo.delete(id);
	}

	@Override
	public List<CarProducer> getAll() {
		// TODO Auto-generated method stub
		return iCarProducerRepo.getAll();
	}

	@Override
	public CarProducer findByID(int id) {
		// TODO Auto-generated method stub
		return iCarProducerRepo.findByID(id);
	}

}

package services;

import java.util.List;

import pojos.Customer;
import repositories.CustomerRepo;
import repositories.ICustomerRepo;

public class CustomerService implements ICustomerService{

	ICustomerRepo iCustomerRepo = null;
	public CustomerService(String configurationFile) {
		if(iCustomerRepo == null) {
			iCustomerRepo = new CustomerRepo(configurationFile);
		}
	}
	
	@Override
	public void save(Customer customer) {
		// TODO Auto-generated method stub
		iCustomerRepo.save(customer);
	}

	@Override
	public void update(Customer customer) {
		// TODO Auto-generated method stub
		iCustomerRepo.update(customer);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		iCustomerRepo.delete(id);
	}

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		return iCustomerRepo.getAll();
	}

	@Override
	public Customer findByID(int id) {
		// TODO Auto-generated method stub
		return iCustomerRepo.findByID(id);
	}

	@Override
	public Customer login(String email, String password) {
		// TODO Auto-generated method stub
		return iCustomerRepo.login(email, password);
	}

}

package repositories;

import java.util.List;

import daos.CustomerDAO;
import pojos.Customer;

public class CustomerRepo implements ICustomerRepo{
	CustomerDAO customerDAO = null;
	public CustomerRepo(String configurationFile) {
		if(customerDAO == null) {
			customerDAO = new CustomerDAO(configurationFile);
		}
	}
	
	@Override
	public void save(Customer customer) {
		// TODO Auto-generated method stub
		customerDAO.save(customer);
	}
	@Override
	public void update(Customer customer) {
		// TODO Auto-generated method stub
		customerDAO.update(customer);
	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		customerDAO.delete(id);
	}
	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		return customerDAO.getAll();
	}
	@Override
	public Customer findByID(int id) {
		// TODO Auto-generated method stub
		return customerDAO.findByID(id);
	}

	@Override
	public Customer login(String email, String password) {
		// TODO Auto-generated method stub
		return customerDAO.login(email, password);
	}
	
	
}

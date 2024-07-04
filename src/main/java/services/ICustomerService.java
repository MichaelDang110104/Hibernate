package services;

import java.util.List;

import pojos.Customer;

public interface ICustomerService {
	public void save(Customer customer);
	public void update(Customer customer);
	public void delete(int id);
	public List<Customer> getAll();
	public Customer findByID(int id);
	public Customer login(String email, String password);
}

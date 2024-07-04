package services;

import java.util.List;

import pojos.Account;

public interface IAccountService {
	public void save(Account account);
	public void update(Account account);
	public void delete(int id);
	public List<Account> getAll();
	public Account findByID(int id);
}

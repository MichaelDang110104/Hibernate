package repositories;

import java.util.List;

import pojos.Account;

public interface IAccountRepo {
	public void save(Account Account);
	public void update(Account Account);
	public void delete(int id);
	public List<Account> getAll();
	public Account findByID(int id);
}

package repositories;

import java.util.List;

import daos.AccountDAO;
import pojos.Account;

public class AccountRepo implements IAccountRepo{
	AccountDAO accountDAO = null;
	public AccountRepo(String configurationFile) {
		if(accountDAO == null) {
			accountDAO = new AccountDAO(configurationFile);
		}
	}

	@Override
	public void save(Account Account) {
		// TODO Auto-generated method stub
		accountDAO.save(Account);
	}

	@Override
	public void update(Account Account) {
		// TODO Auto-generated method stub
		accountDAO.update(Account);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		accountDAO.delete(id);
	}

	@Override
	public List<Account> getAll() {
		// TODO Auto-generated method stub
		return accountDAO.getAll();
	}

	@Override
	public Account findByID(int id) {
		// TODO Auto-generated method stub
		return accountDAO.findByID(id);
	}

}

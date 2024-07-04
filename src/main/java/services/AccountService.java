package services;

import java.util.List;

import pojos.Account;
import repositories.AccountRepo;
import repositories.IAccountRepo;

public class AccountService implements IAccountService {
	IAccountRepo iAccountRepo = null;

	public AccountService(String configurationFile) {
		if (iAccountRepo == null) {
			iAccountRepo = new AccountRepo(configurationFile);
		}
	}

	@Override
	public void save(Account account) {
		// TODO Auto-generated method stub
		iAccountRepo.save(account);
	}

	@Override
	public void update(Account account) {
		// TODO Auto-generated method stub
		iAccountRepo.update(account);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		iAccountRepo.delete(id);
	}

	@Override
	public List<Account> getAll() {
		// TODO Auto-generated method stub
		return iAccountRepo.getAll();
	}

	@Override
	public Account findByID(int id) {
		// TODO Auto-generated method stub
		return iAccountRepo.findByID(id);
	}
}

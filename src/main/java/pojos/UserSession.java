package pojos;

public class UserSession {
	private static UserSession instance;
    private Customer loginUser;
    
    private UserSession() {}
    
    public static UserSession getInstance() {
        if(instance == null) {
            instance = new UserSession();
        }
        return instance;
    }
    
    public void cleanUserSession() {
    	loginUser = null;
    }

	public Customer getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(Customer loginUser) {
		this.loginUser = loginUser;
	}

	@Override
	public String toString() {
		return "UserSession [loginUser=" + loginUser + "]";
	}
    
}

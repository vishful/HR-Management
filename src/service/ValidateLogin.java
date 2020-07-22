package service;

public class ValidateLogin {
		public boolean validate(String username, String password) {
			
			
			if(username.equals("admin") && password.equals("admin"))
				return true;
			else 
				return false;

	}
}

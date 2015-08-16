package edu.acc.j2ee.hubbub2;

public class LoginValidator {

  
	public static boolean validate(LoginBean user) {
		return user.getName().length() == 8 &&
			user.getPassword().length() == 8;
	}
}


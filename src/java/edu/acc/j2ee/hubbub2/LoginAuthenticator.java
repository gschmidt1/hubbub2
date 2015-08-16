
package edu.acc.j2ee.hubbub2;

import javax.servlet.ServletConfig;

public class LoginAuthenticator {
    
	private ServletConfig sc;
	
	public LoginAuthenticator(ServletConfig sc) {
		this.sc = sc;
	}
	public boolean authenticate(LoginBean user) {
		if (user == null || user.getName() == null || user.getPassword() == null)
			return false;
		if (user.getName().equals(sc.getInitParameter("validUserName")) &&
			user.getPassword().equals(sc.getInitParameter("validPassword"))) {
			user.setId(Integer.parseInt(sc.getInitParameter("validId")));
			return true;
		}
		else return false;
	}
}

    
    
    
    


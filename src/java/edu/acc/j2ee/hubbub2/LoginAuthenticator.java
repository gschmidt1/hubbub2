package edu.acc.j2ee.hubbub2;

public class LoginAuthenticator {

    private HubbubDAO db;

    public LoginAuthenticator(HubbubDAO db) {
        this.db = db;
    }

    public boolean authenticate(LoginBean user) {
        if (user == null || user.getName() == null || user.getPassword() == null) {
            return false;
        }
        if (db.userPasswordExists(user.getName(), user.getPassword())) {
            return true;
        } else {
            return false;
        }
    }
}

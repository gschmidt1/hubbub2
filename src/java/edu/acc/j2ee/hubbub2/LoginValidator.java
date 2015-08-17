package edu.acc.j2ee.hubbub2;

public class LoginValidator {

    public static boolean validate(LoginBean user) {
        String checkString = user.getPassword();
        if (checkString.indexOf("<") > 0) {
            return false;
        }
        if (checkString.indexOf(">") > 0) {
            return false;
        }
        if (checkString.indexOf("'") > 0) {
            return false;
        }
        if (checkString.indexOf("\"") > 0) {
         return false;
        }
        if (checkString.indexOf("&") > 0) {
            return false;
        }
        if (user.getName().length() == 0) {
            return false;
        }

        if ((user.getPassword().length() <= 6) || (user.getPassword().length() >= 16)) {
            return false;
        }

        return true;
    }
}

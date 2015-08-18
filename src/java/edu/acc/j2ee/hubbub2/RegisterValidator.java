package edu.acc.j2ee.hubbub2;

public class RegisterValidator {
     public static boolean validate(String regParm) {
        String checkString = regParm;
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
        if (checkString.length() == 0) {
            return false;
        }
        return true;
    }
}

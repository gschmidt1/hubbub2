package edu.acc.j2ee.hubbub2;

public class PostValidator {
    
    public static boolean validate(String textArea) {
        String checkString = textArea;
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

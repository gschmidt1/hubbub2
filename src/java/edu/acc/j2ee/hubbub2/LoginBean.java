package edu.acc.j2ee.hubbub2;

public class LoginBean implements java.io.Serializable {

    private String name;
    private String password;
    private int id;

    public LoginBean() {
    }

    public LoginBean(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("%s", name);
    }
}

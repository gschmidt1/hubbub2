package edu.acc.j2ee.hubbub2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User implements java.io.Serializable {

    private String userName;
    private String userPassword;

    private Date joinDate;
    private List<Post> posts = new ArrayList<>();

    public User(String userName, String userPassword, Date joinDate) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.joinDate = joinDate;
    }

    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setuserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public List<Post> getPosts() {
        return posts;
    }

    @Override
    public String toString() {
        return userName;
    }
}

package edu.acc.j2ee.hubbub2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HubbubDAO {

    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public void addPost(Post post) {
        User author = find(post.getAuthor().getUserName());
        author.getPosts().add(post);
    }

    public User find(String userName) {
        for (User user : users) {
            if (user.getUserName().equals(userName)) {
                return user;
            }
        }
        return null;
    }

    public boolean userPasswordExists(String userName, String userPassword) {
        for (User user : users) {
            if (user.getUserName().equals(userName) && user.getUserPassword().equals(userPassword)) {
                return true;
            }
        }
        return false;
    }

    public List<Post> getSortedPosts() {
        List<Post> posts = new ArrayList<>();
        for (User user : users) {
            posts.addAll(user.getPosts());
        }
        Collections.sort(posts, new PostComparator());
        return posts;
    }
}

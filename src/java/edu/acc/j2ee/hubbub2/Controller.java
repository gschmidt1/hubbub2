package edu.acc.j2ee.hubbub2;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Controller extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String destination = "timeline.jsp";
        HttpSession session = request.getSession();
        LoginBean bean = (LoginBean) session.getAttribute("loginUser");
        
        String loginLinks = request.getParameter("loginLinks");
        if (loginLinks == null) {
            loginLinks = "";
        }
        if (bean == null) {
            destination = "login.jsp";
        }
        if (loginLinks.equals("register")) {
            destination = "registration.jsp";
        }
        if (loginLinks.equals("post")) {
            destination = "post.jsp";
        }
        if (loginLinks.equals("timeline")) {
            destination = "timeline.jsp";
            HubbubDAO db = (HubbubDAO) getServletContext().getAttribute("db");
            List<Post> posts = db.getSortedPosts();
            request.setAttribute("posts", posts);
        }
        if (loginLinks.equals("logout")) {
            session.invalidate();
            destination = "login.jsp";
        }        
        request.getRequestDispatcher(destination).forward(request, response);
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String destination = "login.jsp";
        HttpSession session = request.getSession();
        String loginUser = request.getParameter("userLogin");
        String loginPass = request.getParameter("passLogin");
        String regUser = request.getParameter("regUser");
        String regPass = request.getParameter("regPass");
        String postText = request.getParameter("postText");
        
        HubbubDAO db = (HubbubDAO) getServletContext().getAttribute("db");
        List<Post> posts = db.getSortedPosts();
        
        LoginBean bean = (LoginBean) session.getAttribute("loginUser");
        
        if (regUser == null){
            regUser = "";
        }
        if (regPass == null){
            regPass = "";
        }
         if (postText == null){
            postText = "";
        }
        
        //logging in
        if (bean == null && regUser.length() == 0 && regPass.length() == 0) {
            bean = new LoginBean(loginUser, loginPass);            
            if (LoginValidator.validate(bean)) {
                LoginAuthenticator ua = new LoginAuthenticator(db);
                if (ua.authenticate(bean)) {
                    session.setAttribute("loginUser", bean);
                    destination = "timeline.jsp";
                    request.setAttribute("posts", posts);
                } else {
                    request.setAttribute("flash", "Access Denied");
                }
            } else {
                request.setAttribute("flash", "One or more fields are invalid");
            }
        }
        //register
        
        if (bean == null && regUser.length() > 0 && regPass.length() > 0) {
            if (RegisterValidator.validate(regUser) && RegisterValidator.validate(regPass)) {
                db = (HubbubDAO) getServletContext().getAttribute("db");
                User existUser = new User();
                existUser = db.find(regUser);
                if(existUser != null){
                    destination = "registration.jsp";
                    request.setAttribute("flash", "User already exists");
                }else{
                    destination = "login.jsp";
                    User user = new User(regUser, regPass, new Date());
                    db.addUser(user);
                }
            }else{
                destination = "registration.jsp";
                request.setAttribute("flash", "One or more fields are invalid");
            }
        }

        //posting    
       
        if (bean != null && postText.length() > 0) {  
            if (PostValidator.validate(postText)) {
                destination = "timeline.jsp";
                db = (HubbubDAO) getServletContext().getAttribute("db");
                Post posted = new Post(postText, new Date(), db.find(bean.getName()));
                db.addPost(posted);
                posts = db.getSortedPosts();
                request.setAttribute("posts", posts);
            }else{
                destination = "post.jsp";
                request.setAttribute("flash", "One or more fields are invalid");
            }
        }        
        request.getRequestDispatcher(destination).forward(request, response);
    }
}

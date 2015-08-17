package edu.acc.j2ee.hubbub2;

import java.io.IOException;
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
        User bean = (User)session.getAttribute("userLogin");
        if (bean == null); 
            destination = "login.jsp";
        request.getRequestDispatcher(destination).forward(request, response);
        
        HubbubDAO db = (HubbubDAO)getServletContext().getAttribute("db");
        List<Post> posts = db.getSortedPosts();
        request.setAttribute("posts", posts);
        request.getRequestDispatcher("timeline.jsp").forward(request, response);
    }
    
    @Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String destination = "login.jsp";
		HttpSession session = request.getSession();
		String loginUser = request.getParameter("loginUser");
		String loginPass = request.getParameter("loginPass");
		LoginBean bean = new LoginBean(loginUser, loginPass);
                
		
		HubbubDAO db = (HubbubDAO)getServletContext().getAttribute("db");
                if (LoginValidator.validate(bean)) {
			LoginAuthenticator ua = new LoginAuthenticator(db);
			if( ua.authenticate(bean) ) {
				session.setAttribute("loginUser", bean);
				destination = "timeline.jsp";
			}
			else request.setAttribute("flash", "Access Denied");
		}
		else request.setAttribute("flash", "One or more fields are invalid");
		request.getRequestDispatcher(destination).forward(request, response);			
	}
}

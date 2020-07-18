package com.kashu.website.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kashu.website.entity.User;
import com.kashu.website.repository.UserRepository;
import com.kashu.website.repository.UserRepositoryJdbcImpl;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/jdbcServlet")
public class JdbcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserRepository userDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JdbcServlet() {
        super();
        userDao = new UserRepositoryJdbcImpl();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		User user = userDao.getById(id);
		String name = user.getName();
		
		response.sendRedirect("jdbc.jsp?name=" + URLEncoder.encode(name, "UTF-8"));
	}

}

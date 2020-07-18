package com.kashu.website.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kashu.website.entity.User;
import com.kashu.website.repository.UserRepository;
import com.kashu.website.repository.UserRepositoryDummyImpl;
import com.kashu.website.repository.UserRepositoryJdbcImpl;
import com.kashu.website.utility.MD5Converter;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserRepository userDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        //userDao = new UserRepositoryDummyImpl();
        userDao = new UserRepositoryJdbcImpl();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		//String password_hash = MD5Converter.getMD5hash(password);
		String password_hash = MD5Converter.getMD5hash("Hail HYDRA", password);
		String message = "";
		User user = userDao.login(account, password_hash);
		User existed = userDao.getByAccount(account);
		if(user!=null) {
			message = "登入成功，您好：" + user.getName();
		}else if(existed!=null) {
			message = "密碼錯誤，帳號：[ " + account  + " ] , 密碼：[ " + password  + " ] ";
		}else {
			message = "帳號不存在，帳號：[ " + account  + " ] , 密碼：[ " + password  + " ] ";
		}
		
		response.sendRedirect("index.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
	}

}


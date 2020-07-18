package com.kashu.website.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kashu.website.utility.MD5Converter;

/**
 * Servlet implementation class HashServlet
 */
@WebServlet("/hashServlet")
public class HashServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HashServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String original = request.getParameter("original");
		//String hash = MD5Converter.getMD5hash(original);
		
		//stronger security if we use salt to encrypt string, thank you @hirakujira

		String hash = MD5Converter.getMD5hash("Hail HYDRA",original);
		
		response.sendRedirect("hash.jsp?hash=" + URLEncoder.encode(hash, "UTF-8"));
	}

}


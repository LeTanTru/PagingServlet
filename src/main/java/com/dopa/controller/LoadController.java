package com.dopa.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dopa.model.User;
import com.dopa.service.IUserService;
import com.dopa.service.impl.UserServiceImpl;

/**
 * Servlet implementation class HomeController
 */
@WebServlet(urlPatterns = { "/load" })
public class LoadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoadController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		IUserService userService = new UserServiceImpl();
		List<User> users = userService.getTop3();
		
		int index = 1;
		if (request.getParameter("index") != null)
			index = Integer.parseInt(request.getParameter("index"));
		int userPerPage = 3;

		users = userService.getUserPerPage((index - 1) * userPerPage, userPerPage);

		PrintWriter out = response.getWriter();
		for (User user : users) {
			out.println("<tr>\r\n" + "						<th scope=\"row\">" + user.getUid() + "</th>\r\n"
					+ "						<td>" + user.getUser() + "</td>\r\n" + "						<td>"
					+ user.getPass() + "</td>\r\n" + "						<td>" + user.getIsSeller() + "</td>\r\n"
					+ "						<td>" + user.getIsAdmin() + "</td>\r\n" + "					</tr>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

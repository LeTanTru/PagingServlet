package com.dopa.controller;

import java.io.IOException;
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
@WebServlet("/home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeController() {
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
		int userQuantity = userService.countUsers();
		int userPerPage = 3;
		int endPage = userQuantity / userPerPage;
		int leftUser = userQuantity % userPerPage;

		if (leftUser != 0) {
			endPage++;
		}

//		users = userService.getUserPerPage((index - 1) * userPerPage, userPerPage);

		request.setAttribute("users", users);

		request.setAttribute("endPage", endPage);
		request.setAttribute("index", index);
		request.getRequestDispatcher("home.jsp").forward(request, response);
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

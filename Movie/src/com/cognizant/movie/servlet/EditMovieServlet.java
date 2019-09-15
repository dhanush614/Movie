package com.cognizant.movie.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.movie.dao.MovieItemDao;
import com.cognizant.movie.dao.MovieItemDaoSqlImpl;
import com.cognizant.movie.model.MovieItem;
import com.cognizant.movie.util.DateUtil;

/**
 * Servlet implementation class EditMovieServlet
 */
@WebServlet("/EditMovie")
public class EditMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditMovieServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		MovieItemDaoSqlImpl movieItemDaoSqlImpl = new MovieItemDaoSqlImpl();
		MovieItemDao movieItemDao = movieItemDaoSqlImpl;
		MovieItem movieItem = new MovieItem(Long.parseLong(request.getParameter("movieId")),
				request.getParameter("title"), request.getParameter("boxOffice"),
				Boolean.parseBoolean(request.getParameter("active")),
				DateUtil.convertToDate(request.getParameter("dateOfLaunch")), request.getParameter("genre"),
				Boolean.parseBoolean(request.getParameter("hasTeaser")));
		movieItemDao.modifyMovieItem(movieItem);
		RequestDispatcher dispatcher = request.getRequestDispatcher("edit-movie-status.jsp");
		dispatcher.forward(request, response);
	}

}

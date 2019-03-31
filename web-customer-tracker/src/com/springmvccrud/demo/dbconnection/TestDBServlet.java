package com.springmvccrud.demo.dbconnection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDBServlet
 */
@WebServlet("/TestDBServlet")
public class TestDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user = "SYSTEM";
		String password = "SYSTEM";
		String url = "jdbc:oracle:thin:@//localhost:1521/orcl";
		String driver = "oracle.jdbc.driver.OracleDriver";

		try {
			PrintWriter out = response.getWriter();
			out.println("Connecting to DB " + url);
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(url, user, password);
			if (connection != null) {
				out.println("Connected");
			} else {
				out.println("Not Connected");
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}

	}

}

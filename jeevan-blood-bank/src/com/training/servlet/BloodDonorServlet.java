package com.training.servlet;



import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.assignment.services.DonorService;
import com.assignment.services.LoginService;
import com.training.model.BloodDonor;
import com.trainingutils.DbConnectionUtil;

/**
 * Servlet implementation class BloodDonorServlet
 */
@WebServlet("/donor")
public class BloodDonorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	private Connection con;
	DonorService bloodD ;
	LoginService login;
	
    public BloodDonorServlet() {
        super();
        bloodD =new DonorService();
        con=DbConnectionUtil.getMySqlConnection();
        login=new LoginService();
        System.out.println(con);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		List<BloodDonor> list=bloodD.findAll();
		
        request.setAttribute("donorList",list);
        
        RequestDispatcher disp=request.getRequestDispatcher("viewDonor.jsp");
        disp.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if (request.getParameter("login")!= null) {
			
			int loginId = Integer.parseInt(request.getParameter("loginId"));
			String password = request.getParameter("password");
			boolean check = login.checkPassword(loginId, password);
			session.setAttribute("valid", check);
			RequestDispatcher dispatcher1 = request.getRequestDispatcher("Welcome.jsp");
			dispatcher1.forward(request, response);
			
		}
		
		if (request.getParameter("add")!= null &&  (boolean)session.getAttribute("valid") ) {
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			String gender = request.getParameter("gender");
			String bloodgroup = request.getParameter("bloodgroup");
			int phonenumber = Integer.parseInt(request.getParameter("phonenumber"));
			String email = request.getParameter("email");
			String date = request.getParameter("dateofbirth");
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate dob = LocalDate.parse(date, formatter);
			BloodDonor donor = new BloodDonor(name, age, gender, bloodgroup, phonenumber, email, dob);
			int row = bloodD.addDonor(donor);
			request.setAttribute("row", row);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Welcome.jsp");
			dispatcher.forward(request, response);
		}
		if(request.getParameter("add")!= null &&  !(boolean)session.getAttribute("valid")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	}

	public void add() {
		
	}
	
	@Override
	public void destroy() {

		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}

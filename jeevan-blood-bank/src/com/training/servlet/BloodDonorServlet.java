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

import com.assignment.services.DonorService;

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
	
    public BloodDonorServlet() {
        super();
        bloodD =new DonorService();
        con=DbConnectionUtil.getMySqlConnection();
        
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
		
		String name=request.getParameter("name");
		int age=Integer.parseInt(request.getParameter("age"));
		String gender=request.getParameter("gender");
		String bloodgroup=request.getParameter("bloodgroup");
		int phonenumber=Integer.parseInt(request.getParameter("phonenumber"));
		String email=request.getParameter("email");
		String date=request.getParameter("dateofbirth");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dob= LocalDate.parse(date,formatter);
		
		BloodDonor donor=new BloodDonor(name,age,gender,bloodgroup,phonenumber,email,dob);
		
		int row=bloodD.addDonor(donor);
		request.setAttribute("row",row);
		RequestDispatcher dispatcher1 =request.getRequestDispatcher("index.jsp");
    	dispatcher1.forward(request, response);
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

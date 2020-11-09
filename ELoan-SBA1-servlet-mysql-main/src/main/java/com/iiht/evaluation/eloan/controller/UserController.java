package com.iiht.evaluation.eloan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iiht.evaluation.eloan.dao.ConnectionDao;
import com.iiht.evaluation.eloan.model.Adminuser;
import com.iiht.evaluation.eloan.model.ApprovedLoan;
import com.iiht.evaluation.eloan.model.LoanInfo;
import com.iiht.evaluation.eloan.model.User;
import com.mysql.cj.xdevapi.Statement;
import javax.servlet.http.HttpSession;



@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ConnectionDao connDao;
	
	public void setConnDao(ConnectionDao connDao) {
		this.connDao = connDao;
	}
	public void init(ServletConfig config) {
		String jdbcURL = config.getServletContext().getInitParameter("jdbcUrl");
		String jdbcUsername = config.getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = config.getServletContext().getInitParameter("jdbcPassword");
		System.out.println(jdbcURL + jdbcUsername + jdbcPassword);
		this.connDao = new ConnectionDao(jdbcURL, jdbcUsername, jdbcPassword);
		try {
			connDao.connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	static String Logid="";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		
		String adminuser= request.getParameter("Adminid");
		String adminpass= request.getParameter("Adminpassword");
		String newlogid= request.getParameter("loginid");
		String newpassword= request.getParameter("password");
		
		String loanname= request.getParameter("loanname");		
		String amount= request.getParameter("amount");
		String date= request.getParameter("date");
		String BusinessStructure= request.getParameter("BusinessStructure");
		String BillingInd= request.getParameter("BillingInd");
		String TaxInd= request.getParameter("TaxInd");
		String MobileNumber= request.getParameter("MobileNumber");		
		String Email= request.getParameter("Email");
		String Address= request.getParameter("Address");
		
		LoanInfo Loan= new LoanInfo(loanname, amount, date, BusinessStructure, BillingInd, Address, Email, MobileNumber, "Applied", TaxInd);
		request.setAttribute("LoanInfo", Loan);
		
		
		//HttpSession session= request.getSession();
		
		
		//equest.setAttribute("LoanInfo", Loan);
		
		Adminuser U1= new Adminuser(adminuser, adminpass);
		request.setAttribute("adminuser", U1);
		
		
//		User ExistingUser= new User(Logid, Password);
//		request.setAttribute("Euser", ExistingUser);
	
		
		User U2= new User(newlogid, newpassword);
		request.setAttribute("user", U2);
		
		String viewName = "";
		try {
			switch (action) {
			case "registerNewUser":
				viewName=registerNewUser(request,response);
				break;
			case "adminvalidate":
				viewName=adminvalidate(request,response);
				break;
			case "validate":
				viewName=validate(request,response);
				break;
			case "placeloan":
				viewName=placeloan(request,response);
				break;
			case "application1":
				viewName=application1(request,response);
				break;
			case "editLoanProcess"  :
				viewName=editLoanProcess(request,response);
				break;
			case "registeruser":
				viewName=registerUser(request,response);
				break;
			case "register":
				viewName = register(request, response);
				break;
			case "application":
				viewName = application(request, response);
				break;
			case "trackloan":
				viewName = trackloan(request, response);
				break;
			case "editloan":
				viewName = editloan(request, response);
				break;	
			case  "displaystatus" :
				viewName=displaystatus(request,response);
				break;
			default : viewName = "notfound.jsp"; break;	
			}
		} catch (Exception ex) {
			
			throw new ServletException(ex.getMessage());
		}
			RequestDispatcher dispatch = 
					request.getRequestDispatcher(viewName);
			dispatch.forward(request, response);
	}
	private String validate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		 Logid= request.getParameter("Userid");
	 	String Password= request.getParameter("Userpassword");
	 	
	 	User ExistingUser= new User(Logid, Password);
	 	HttpSession session= request.getSession();
	 	session.setAttribute("user", ExistingUser);
		//User EUser= (User)request.getAttribute("Euser");
		//connDao.connect();
		String status=connDao.authenticateUser(ExistingUser);
		
		//response.sendRedirect("userhome1.jsp");
		if(status.contains("Success")){
			//response.sendRedirect("userhome.jsp");
			RequestDispatcher dispatcher= request.getRequestDispatcher("userhome.jsp");
			
			dispatcher.forward(request, response);
			
		}
		else{
			PrintWriter writer= response.getWriter();
			writer.write("<h1>Invalid credentials</h1>");
			
		}
		return null;
	}
	
	private String adminvalidate(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		/* write the code to validate the user */
		
		Adminuser u1=(Adminuser)request.getAttribute("adminuser");
		if(u1.getUsername().contains("admin") && u1.getPassword().contains("admin")){
			
			//response.sendRedirect("adminhome1.jsp");
			RequestDispatcher dispatcher= request.getRequestDispatcher("adminhome1.jsp");
			dispatcher.forward(request, response);
		}
		
		return null;
	}
	private String placeloan(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
	/* write the code to place the loan information */
		
		
		//Logid= request.getParameter("Userid");
	 	String Password= request.getParameter("Userpassword");
	 	
	 	User ExistingUser= new User(Logid, Password);
		LoanInfo loan=(LoanInfo)request.getAttribute("LoanInfo");
		//User EUser1= (User)request.getAttribute("Euser1");
		
		int Status= connDao.ApplyLoan(loan, ExistingUser);
		
		if(Status>0){
			
			RequestDispatcher dispatcher= request.getRequestDispatcher("userhome1.jsp");
			dispatcher.forward(request, response);
		}
		else{
			//response.sendRedirect("userhome.jsp");
			RequestDispatcher dispatcher= request.getRequestDispatcher("userhome.jsp");
			dispatcher.forward(request, response);
		}
		
		return null;
	}
	private String application1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	/* write the code to display the loan application page */
		RequestDispatcher dispatcher= request.getRequestDispatcher("application.jsp");
		dispatcher.forward(request, response);
		return null;
	}
	private String editLoanProcess(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		/* write the code to edit the loan info */
		String loanname= request.getParameter("eloanname");		
		String amount= request.getParameter("eamount");
		String date= request.getParameter("edate");
		String BusinessStructure= request.getParameter("eBusinessStructure");
		String BillingInd= request.getParameter("eBillingInd");
		String TaxInd= request.getParameter("eTaxInd");
		String MobileNumber= request.getParameter("eMobileNumber");		
		String Email= request.getParameter("eEmail");
		String Address= request.getParameter("eAddress");
		String loanId= request.getParameter("LoanID");
		
		connDao.updateLoan(loanId, loanname, amount, date, BusinessStructure, BillingInd, TaxInd, MobileNumber, Email, Address);
		return "editloanui.jsp";
	}
	private String registerUser(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		/* write the code to redirect page to read the user details */
		return "newuserui.jsp";
	}
	private String registerNewUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
		/* write the code to create the new user account read from user 
		   and return to index page */
		User u2= (User)request.getAttribute("user");
		//connDao.connect();
		int status=connDao.NewUser(u2);
		
		//response.sendRedirect("index.jsp");
		if(status>0){
			RequestDispatcher dispatcher= request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
		else{
			PrintWriter writer= response.getWriter();
			writer.write("<h1>user not updated</h1>");
		}
		return null;
	}
	
	private String register(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		/* write the code to redirect to register page */
		
		return null;
	}
	private String displaystatus(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		/* write the code the display the loan status based on the given application
		   number 
		*/
		
		return null;
	}

	private String editloan(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
	/* write a code to return to editloan page */
		String loanId= request.getParameter("LoanID");
		LoanInfo AppliedLoan= connDao.getuserLoans(loanId);
		request.setAttribute("Loan", AppliedLoan);
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("editloanui.jsp");
		dispatcher.forward(request, response);
		
		return null;
	}

	private String trackloan(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
	/* write a code to return to trackloan page */
		String userId = request.getParameter("userid");
		List<LoanInfo> loans = connDao.getLoanStatus(userId);
		request.setAttribute("loans", loans);
		return null;
	}

	private String application(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	/* write a code to return to trackloan page */
		return null;
	}
}
package com.iiht.evaluation.eloan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

import com.iiht.evaluation.eloan.dto.LoanDto;
import com.iiht.evaluation.eloan.model.ApprovedLoan;
import com.iiht.evaluation.eloan.model.LoanInfo;
import com.iiht.evaluation.eloan.model.User;

public class ConnectionDao {
	private static final long serialVersionUID = 1L;
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;

	public ConnectionDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

	public  Connection connect() throws SQLException {
		if (jdbcConnection == null || jdbcConnection.isClosed()) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		}
		return jdbcConnection;
	}

	public void disconnect() throws SQLException {
		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}
	
	// put the relevant DAO methods here..
	
	
	public int NewUser(User Us) throws SQLException{
		int result= 0;
		String SQL1= "insert into users(LoginID, Password) values(?,?)";
		PreparedStatement presmt= jdbcConnection.prepareStatement(SQL1);
		presmt.setString(1, Us.getUsername());
		presmt.setString(2, Us.getPassword());
		result= presmt.executeUpdate();
		
		return result;
	}
	
	public String authenticateUser(User Us) throws SQLException{
		String result= new String();
		//String SQL1= "Select * from users";
		Statement smt= jdbcConnection.createStatement();
		ResultSet rs= smt.executeQuery("select * from users where LoginID='"+ Us.getUsername() +"' and Password='"+ Us.getPassword() +"'");
		//rs.beforeFirst();
		
//		while(rs.next()){
//			String name= rs.getString("LoginID");
//			String Pwd= rs.getString("Password");
//			
//			if(name.contains(Us.getUsername()) && Pwd.contains(Us.getPassword())){
//				result="Success";
//			}
//			else{
//				result="Invalid User";
//			}
//		}
		if(rs.next()){
			result="Success";
		}
		else{
			result="Invalid User";
		}
		
		rs.close();
		return result;
	}
	
	public int ApplyLoan(LoanInfo ln, User u) throws SQLException{
		int result= 0;
		String SQL1= "insert into loans(Loan_Number, Loan_Name, Amount, Date, Business, Tax, Billing, Phone, Email, Address, Status, LoginID) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement presmt= jdbcConnection.prepareStatement(SQL1);
		presmt.setString(1, ln.getApplno());
		presmt.setString(2, ln.getPurpose());
		presmt.setString(3, ln.getAmtrequest());
		presmt.setString(4, ln.getDoa());
		presmt.setString(5, ln.getBstructure());
		presmt.setString(6, ln.getTaxInd());
		presmt.setString(7, ln.getBindicator());
		presmt.setString(8, ln.getMobile());
		presmt.setString(9, ln.getEmail());
		presmt.setString(10, ln.getAddress());
		presmt.setString(11, ln.getStatus());
		presmt.setString(12, u.getUsername());
		//System.out.println(u.getUsername());
		result= presmt.executeUpdate();
		
		return result;
	}
	
	public LoanInfo getuserLoans(String loannum) throws SQLException{
		List<LoanInfo> ln= new ArrayList<>();
		Statement smt= jdbcConnection.createStatement();
		ResultSet rs= smt.executeQuery("select * from loans where Loan_Number='"+ loannum +"'");
		LoanInfo loan = new LoanInfo();
		if(rs.next()){
			
			loan.setPurpose(rs.getString("Loan_Name"));
			loan.setAmtrequest(rs.getString("Amount"));
			loan.setDoa(rs.getString("Date"));
			loan.setBstructure(rs.getString("Business"));
			loan.setTaxInd(rs.getString("Tax"));
			loan.setBindicator(rs.getString("Billing"));
			loan.setMobile(rs.getString("Phone"));
			loan.setEmail(rs.getString("Email"));
			loan.setAddress(rs.getString("Address"));
			loan.setStatus(rs.getString("Status"));
		}
		return loan;
	}
	public boolean updateLoan(String loanId, String loanname, String amount, String date, String BusinessStructure, String BillingInd, String TaxInd, String MobileNumber, String Email, String Address) throws SQLException {
		jdbcConnection = connect();
		Statement st = jdbcConnection.createStatement();
		
		String sql = "UPDATE loans SET Loan_Name = "+ "'" + loanname + "'" + "," + "Amount = "+ "'" + amount + "'" + "," +"Date = "+ "'" + date + "'" + "," +"Business = "+ "'" + BusinessStructure + "'" + "," +"Tax = "+ "'" + TaxInd + "'" + "," +"Billing = "+ "'" + BillingInd + "'" + "," +"Phone = "+ "'" + MobileNumber + "'" + "," +"Email = "+ "'" + Email + "'" + "," +"Address = "+ "'" + Address + "'" +" WHERE Loan_Number="+loanId;
		int success = st.executeUpdate(sql);
		return success ==1;
		}
	
	public List<LoanInfo>  getLoanStatus(String userId) throws SQLException{
		jdbcConnection = connect();
		Statement st = jdbcConnection.createStatement();
		String sql = "select * from loans where id="+userId;
		ResultSet rs = st.executeQuery(sql);
		
		List<LoanInfo> loans = new ArrayList<LoanInfo>();
		while(rs.next()){
			LoanInfo loan = new LoanInfo();
			loan.setApplno(rs.getString("Loan_Number"));	
			String status= rs.getString("Status");
			
			loan.setStatus(status);
			loans.add(loan);
		}
		return loans;
	}
	
	public List<LoanInfo> getUserLoansList() throws SQLException{
		jdbcConnection = connect();
		Statement smt = jdbcConnection.createStatement();
		String sql = "select * from loans";
		ResultSet rs = smt.executeQuery(sql);
		List<LoanInfo> loans = new ArrayList<LoanInfo>();
		while(rs.next()){
			LoanInfo loan = new LoanInfo();
			loan.setApplno(rs.getString("Loan_Number"));				
			loan.setAmtrequest(rs.getString("Amount"));
			loan.setBstructure(rs.getString("Business"));
			loan.setDoa(rs.getString("Date"));
			loan.setBindicator(rs.getString("Billing"));
			loan.setAddress(rs.getString("Address"));
			loan.setPurpose(rs.getString("Loan_Name"));
			loans.add(loan);
		}
		
		
		return loans;
	}
	
	public boolean updateLoanStatus(String loanId, String status) throws SQLException {
		jdbcConnection = connect();
		Statement st = jdbcConnection.createStatement();
		String sql = "UPDATE loans SET Status = "+ "'" + status + "'" +  " WHERE Loan_Number="+loanId;
		int success = st.executeUpdate(sql);
		return success ==1;
		}
	
	public boolean saveApprovedLoan(String loanId, double sanctionedAmount, int loanTerm,
			String paymentStartDate, String loanClosureDate, double emi) throws SQLException {
		jdbcConnection = connect();
		Statement st = jdbcConnection.createStatement();
		String sql = "INSERT INTO Approvedloans (amountsanctioned, loanterm, psd,lcd, emi, loanid) "
				+ "VALUES( " + "'" + sanctionedAmount + "'" + "," + "'" + loanTerm + "'" + "," + "'" + paymentStartDate + "'"
				+ "," +  "'" + loanClosureDate +  "'" + "," + "'" + emi + "'" +  "," + "'" + loanId
				+ "'" + ")";
		int success = st.executeUpdate(sql);
		return success == 1;
		
		}
}

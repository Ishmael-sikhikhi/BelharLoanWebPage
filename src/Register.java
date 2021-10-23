/*
 * 211215961
 * 04 Nov 2019
 * */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Belhar
 */
@WebServlet("/Belhar")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static PrintWriter out;
	static DateTimeFormatter dtf;
	static LocalDateTime tm;

	protected void help(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, Exception{
		
	
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		 out = response.getWriter();
		 dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd:HH:mm:ss");
		 tm = LocalDateTime.now();
		 
		 String time = tm.format(dtf);
		 try {
				DatabaseConnection db = new DatabaseConnection(); // creating  database  instance for the queries
				
				String staffNumber =  request.getParameter("staffNumber");
				String name = request.getParameter("name");
				String surname = request.getParameter("surname");
				String phone = request.getParameter("phoneNo"); 
				String email = request.getParameter("email");
				
		 		        
		      out.print("Arriving time is " + time);
		      out.print("</br>timeIn: " + time);
		 
		
		int result = db.addBorrower(staffNumber, name, surname, phone, email, time);
		
		
		
		if(result == 1) {
			
		}
	}catch(NumberFormatException ex) {
		
		out.println("id number</br>: "+request.getParameter("idNo"));
		
	} 
		catch (ClassNotFoundException e) {	
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}





	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		out = response.getWriter();
		
		
	}

}

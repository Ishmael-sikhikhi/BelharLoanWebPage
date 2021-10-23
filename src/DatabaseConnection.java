import java.sql.*;



public class DatabaseConnection{
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	Statement st;
	static String query = "insert into registration"
			+ "(staffNumber, name, surname, phone, email, timeIn) values(?,?,?,?,?,?)"; 
	
	
	public DatabaseConnection() throws Exception {
		
			
			
			Class.forName("com.mysql.jdbc.Driver");
		    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","cput");
			 ps = con.prepareStatement(query);
			 st = con.createStatement();
		
		}
	
			public int addBorrower(String staffNumber, String firstName, String lastName, String phoneNumber,String email, String timeIn) {
			try 
			{// inserting into database use prepared statement
				
				ps.setString(1, staffNumber);
				ps.setString(2,firstName);
				ps.setString(3,lastName);
				ps.setString(4,phoneNumber);
				ps.setString(5, email);
				ps.setString(6, timeIn);
				
				
				
				return ps.executeUpdate();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		return 0;
	}
			
			public int approved(String id) throws SQLException { // method for selecting
				 rs = st.executeQuery("select * from status where staffNo = '"+id+"';");
				
				return 0;
			}
	
}
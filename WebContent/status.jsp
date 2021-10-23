<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	try {
			DatabaseConnection db = new DatabaseConnection();
			
			String idNo =  request.getParameter("idNo");
			int result = db.approved(idNo);
			while(db.rs.next()) {
				out.print("Your application has been "+db.rs.getString("status"));
			}
			
			if(result == 1) {
				out.println("ID doesn't exist or has regected!");
			}
			} catch (Exception e) {
				
				e.printStackTrace();
			}
	
	%>
</body>
</html>
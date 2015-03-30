<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="moviepedia.dao.*,moviepedia.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Profile</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
</head>
<body>
<div>
        
        
        <%
        UserManager userDAO = new UserManager();
        
        String usr = request.getParameter("username");
        
        
        User user = userDAO.readUser(usr);
        %>
        <div class='container'>
        <h1>Profile Page</h1>
        <table class='table table-bordered'>
        <thead>
        <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>DOB</th>
        </tr>        
        </thead>
        <tbody>
        <tr>
        <td><%=user.getFirstName() %></td>
        <td><%=user.getLastName() %></td>
        <td><%=user.getEmail() %></td>
        <td><%=user.getDob() %></td>
        </tbody>
        </table>
        
       <%--  <ul>
        <%
        for(Movie movie : user.getLikes())
        {
        %> <li><%= movie.getTitle() %></li>
        <%}
        %>
        
        </ul> --%>
        
        </div>
</body>
</html>
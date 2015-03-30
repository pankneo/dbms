<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="moviepedia.dao.*,moviepedia.model.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User List</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
    <h1>Users</h1>
    
    <%
    UserManager userDAO = new UserManager();
    
    String action = request.getParameter("action");
    String username = request.getParameter("username");
    String firstName  = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");
    String email=request.getParameter("email");
    String password=request.getParameter("password");
    String dob=request.getParameter("dob");
    
    if("create".equals(action))
    {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(password);  
        user.setEmail(email);
        user.setUserName(username);
        userDAO.createUser(user);
    }
    else if("delete".equals(action))
    {
       
        userDAO.deleteUser(username);   
    }
    else if("update".equals(action))
    {
        
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        userDAO.updateUser(username, user);
    }
    
    
    List<User> users = userDAO.readAllUsers();
    %>
    
    <form action="UserList.jsp">
    <table class="table table-striped">
        <thead>
            <tr>
               
                <th>First Name</th>
                <th>Last Name</th>
                 <th>Username</th>
            </tr>
            <tr>
                
                <th><input class="form-control" name="firstName" placeholder="First Name" value="<%=firstName%>"/></th>
                <th><input class="form-control" name="lastName" placeholder="Last Name" value="<%=lastName%>"/></th>
                <th><input class="form-control" name="username" value="<%=username%>"/></th>
                
                <th>
                    <button class="btn btn-success" name="action" value="create">Add</button>
                    <button class="btn btn-primary" name="action" value="update">Update</button>
                </th>
            </tr>
        </thead>
        <tbody>
    <%
    for(User user : users)
    {
        %>
            <tr>
                <td><%=user.getFirstName() %></td>
                <td><%=user.getLastName() %></td>
                <td><a href="UserProfile.jsp?username=<%=user.getUserName()%>"><%=user.getUserName() %></a></td>                
                <td>
                    <a class="btn btn-danger" href="UserList.jsp?action=delete&username=<%=user.getUserName() %>">Delete</a>
                    <a class="btn btn-warning" href="UserList.jsp?action=select&username=<%=user.getUserName() %>&firstName=<%=user.getFirstName()%>&lastName=<%=user.getLastName()%>">Select</a>
                </td>
            </tr>
        <%
    }
    %>
        </tbody>
    </table>
    </form>
    </div>
</body>
</html>
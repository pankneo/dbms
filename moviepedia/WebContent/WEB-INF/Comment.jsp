<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="moviepedia.dao.*,moviepedia.model.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Comments</title>
</head>
<body>
<%
CommentManager cm=new CommentManager();
User user=new User("huntethan","pass","Ethan","Hunt","hunt@h.com",new Date(1998/3/1));
UserManager usr=new UserManager();
usr.createUser(user);
Comment comment=new Comment("first comment",new Date(1998/2/3),1,1,"hunethan");
cm.createComment(comment);
cm.readAllComments();
cm.readAllCommentsForMovie(1);
Comment newcomment=new Comment("second comment",new Date(1998/2/3),1,1,"hunethan");
cm.updateComment(1, newcomment);
cm.readAllCommentsForUsername("huntethan");
cm.readCommentForId(1);
//cm.deleteComment(1);
%>
</body>
</html>
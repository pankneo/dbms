<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="moviepedia.dao.*,moviepedia.model.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Actors</title>
</head>
<body>
<%
ActorManager am=new ActorManager();
Actor  actor=new Actor(1,"Ethan","Hunt",new Date(2001/3/3));
am.createActor(actor);
am.readAllActors();
am.readActor(1);
Actor  newactor=new Actor(1,"Tom","Cruise",new Date(2001/3/3));
am.updateActor(1, newactor);
//am.deleteActor(1);
%>
</body>
</html>
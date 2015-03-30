<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="moviepedia.dao.*,moviepedia.model.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cast</title>
</head>
<body>
<% 
CastManager cm=new CastManager();
Cast cast=new Cast(1,1,1,"Neo Anderson");
cm.createCast(cast);
cm.readAllCast();
cm.readAllCastForActor(1);
Cast newcast=new Cast(1,1,1,"Trinity");
cm.updateCast(1, newcast);
cm.readAllCastForMovie(1);
cm.readCastForId(1);
//cm.deleteCast(1);

%>

</body>
</html>
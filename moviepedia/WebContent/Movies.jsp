<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="moviepedia.dao.*,moviepedia.model.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movies</title>
</head>
<body>
<%
MovieManager mm=new MovieManager();
Movie movie=new Movie(1,"Matrix","matrix.com",new Date(1999/3/2));

mm.createMovie(movie);
mm.readAllMovies();
mm.readMovie(1);
Movie newmovie=new Movie(1,"Matrix revolution","matrixrev.com",new Date(2001/3/2));
mm.updateMovie(1, newmovie);
//mm.deleteMovie(1);

%>
</body>
</html>
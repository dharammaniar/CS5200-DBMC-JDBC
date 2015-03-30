<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="cs5200.dbms.jdbc.manager.*,cs5200.dbms.jdbc.entity.*,java.util.*,java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <div>
        <h1>Movie Details</h1>
        
        <%
        MovieManager movieManager = new MovieManager();
        
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        
        Movie movie = movieManager.readMovie(id);
        %>
        
        Title: <%=movie.getTitle() %>
        Poster Image: <%=movie.getPosterImage() %>
        Release Date: <%=movie.getReleaseDate() %>
    </div>
</body>
</html>
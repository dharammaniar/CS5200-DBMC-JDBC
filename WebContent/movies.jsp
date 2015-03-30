<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="cs5200.dbms.jdbc.manager.*,cs5200.dbms.jdbc.entity.*,java.util.*,java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Movies</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
    <h1>Movies</h1>
    
    <%
    MovieManager movieManager = new MovieManager();
    
    String action = request.getParameter("action");
    String id = request.getParameter("id");
    String title  = request.getParameter("title");
    String posterImage = request.getParameter("posterImage");
    String date = request.getParameter("releaseDate");
    
    if("create".equals(action))
    {
    	Date releaseDate = Date.valueOf(date);
    	Movie movie = new Movie();
        movie.setTitle(title);
        movie.setPosterImage(posterImage);
        movie.setReleaseDate(releaseDate);
        movieManager.createMovie(movie);
    }
    else if("delete".equals(action))
    {
    	int movieId = Integer.parseInt(id);
    	movieManager.deleteMovie(movieId);
    }
    else if("update".equals(action))
    {
    	int movieId = Integer.parseInt(id);
    	Date releaseDate = Date.valueOf(date);
        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setPosterImage(posterImage);
        movie.setReleaseDate(releaseDate);
        movieManager.updateMovie(movieId, movie);
    }
    
    
    List<Movie> movies = movieManager.readAllMovies();
    %>
    
    <form action="movies.jsp">
    <table class="table table-striped">
        <thead>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Poster</th>
                <th>Release Date</th>
            </tr>
            <tr>
                <th><input class="form-control" name="id" value="<%=id%>" readonly/></th>
                <th><input class="form-control" name="title" placeholder="Title" value="<%=title%>"/></th>
                <th><input class="form-control" name="posterImage" placeholder="Poster URL" value="<%=posterImage%>"/></th>
                <th><input class="form-control" name="releaseDate" placeholder="Release Date" value="<%=date%>"/></th>
                <th>
                    <button class="btn btn-success" name="action" value="create">Add</button>
                    <button class="btn btn-primary" name="action" value="update">Update</button>
                </th>
            </tr>
        </thead>
        <tbody>
    <%
    for(Movie movie : movies)
    {
        %>
            <tr>
                <td><%=movie.getId() %></td>
                <td><a href="movieDetails.jsp?id=<%=movie.getId()%>"><%=movie.getTitle() %></a></td>
                <td><%=movie.getPosterImage() %></td>
                <td><%=movie.getReleaseDate() %></td>
                <td>
                    <a class="btn btn-danger" href="movies.jsp?action=delete&id=<%=movie.getId() %>">Delete</a>
                    <a class="btn btn-warning" href="movies.jsp?action=select&id=<%=movie.getId() %>&title=<%=movie.getTitle()%>&posterImage=<%=movie.getPosterImage()%>&movieId=<%=movie.getReleaseDate()%>">Select</a>
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
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Movie</title>
<link rel="stylesheet" type="text/css" href="style/style.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<script type="text/javascript" src="js/script.js"></script>
	<nav>
		<ul>
			<li><a href="ShowMovieListAdmin">Movie Cruiser&emsp;<img
					src="images/movie.png" width="50cm"></a></li>
			<li><a class="movie-link" href="ShowMovieListAdmin">Movies</a></li>
		</ul>
	</nav>
	<p class="heading-edit-movie">Edit Movie</p>
	<br>
	<form name="movieItem" method="post"
		action="EditMovie?movieId=${requestScope.movieItem.id }">
		<c:set var="movieItem" value="${requestScope.movieItem }"></c:set>
		<label class="gray-text table-header-position" for="title">Title</label>
		<input class="edit-textbox" type="text" size="100cm" id="title"
			name="title" value="<c:out value="${movieItem.title }"/>" required><br>
		<label class="gray-text label-position" for="boxOffice">Box
			office</label><label class="gray-text label-position2" for="active">Active</label><label
			class="gray-text label-position3" for="dateOfLaunch">Date of
			Launch</label><label class="label-position4 gray-text" for="genre">Genre</label><br>
		<input type="text" class="edit-textbox1"
			value="<c:out value="${movieItem.boxOffice }"/>" required size="10cm"
			id="boxOffice" name="boxOffice"><input type="radio"
			class="form-radio" id="active" name="active" value="true"
			<c:if test="${movieItem.active}">checked</c:if>> Yes&emsp;<input
			type="radio" class="form-radio" id="active" name="active"
			value="false"
			<c:if test="${movieItem.active == false}">checked</c:if>> No
		<input type="text" class="edit-textbox1"
			value="<fmt:formatDate
						value="${movieItem.dateOfLaunch}" pattern="dd/MM/yyyy" />"
			required id="dateOfLaunch" name="dateOfLaunch"> <select
			class="edit-textbox1" id="genre" name="genre">
			<option value="Science Fiction"
				<c:if test="${movieItem.genre == 'Science Fiction'}">selected</c:if>>Science
				Fiction</option>
			<option value="Superhero"
				<c:if test="${movieItem.genre == 'Superhero'}">selected</c:if>>Superhero</option>
			<option value="Romance"
				<c:if test="${movieItem.genre == 'Romance'}">selected</c:if>>Romance</option>
			<option value="Comedy"
				<c:if test="${movieItem.genre == 'Comedy'}">selected</c:if>>Comedy</option>
			<option value="Adventure"
				<c:if test="${movieItem.genre == 'Adventure'}">selected</c:if>>Adventure</option>
			<option value="Thriller"
				<c:if test="${movieItem.genre == 'Thriller'}">selected</c:if>>Thriller</option>
		</select><br> <input class="form-check label-position" type="checkbox"
			name="hasTeaser" id="hasTeaser" value="true"
			<c:if test="${movieItem.hasTeaser}">checked</c:if>> <label
			for="hasTeaser" class="gray-text teaser-link">Has Teaser</label><br>
		<button name="submit" onclick="return validateForm()"
			class="button label-position">Save</button>
	</form>
	<footer class="footer-edit-movie-item"> Copyright &copy 2019 </footer>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Movie List Admin</title>
<link rel="stylesheet" type="text/css" href="style/style1.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<nav>
		<ul>
			<li><a href="ShowMovieListAdmin">Movie Cruiser&emsp;<img
					src="images/movie.png" width="50cm"></a></li>
			<li><a class="movie-link" href="ShowMovieListAdmin">Movies</a></li>
		</ul>
	</nav>
	<table align="center" width="85%" cellpadding="6">
		<caption>Movies</caption>
		<tr>
			<th class="left-align">Title</th>
			<th class="right-align">Box Office</th>
			<th>Active</th>
			<th>Date of Launch</th>
			<th>Genre</th>
			<th>Has Teaser</th>
			<th>Action</th>
		</tr>
		<c:set var="movieItemList" value="${requestScope.movieItemList }"></c:set>
		<c:forEach var="movieItem" items="${movieItemList }">
			<tr>
				<td class="left-align"><c:out value="${movieItem.title }" /></td>
				<td class="right-align"><fmt:setLocale value="en_US" />
					<fmt:formatNumber value="${movieItem.boxOffice}"
						maxFractionDigits="0" type="currency" /></td>
				<td class="center-align"><c:set var="active"
						value="${movieItem.active }"></c:set> <c:choose>
						<c:when test="${active==true }">
							<c:out value="Yes" />
						</c:when>
						<c:otherwise>
							<c:out value="No" />
						</c:otherwise>
					</c:choose></td>
				<td class="center-align"><fmt:formatDate
						value="${movieItem.dateOfLaunch}" pattern="dd/MM/yyyy" /></td>
				<td class="center-align"><c:out value="${movieItem.genre }" /></td>
				<td class="center-align"><c:set var="active"
						value="${movieItem.hasTeaser }"></c:set> <c:choose>
						<c:when test="${active==true }">
							<c:out value="Yes" />
						</c:when>
						<c:otherwise>
							<c:out value="No" />
						</c:otherwise>
					</c:choose></td>
				<td class="center-align"><a class="black-link"
					href="ShowEditMovie?movieId=${movieItem.id }">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
	<footer class="footer-movie-item-admin"> Copyright &copy 2019
	</footer>
</body>
</html>
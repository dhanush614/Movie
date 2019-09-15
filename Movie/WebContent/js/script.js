function validateForm() {
	var titleName = document.movieItem.title.value;
	var boxOffice = document.movieItem.boxOffice.value;
	var flag = 0;
	var genre = document.getElementById("genre");
	if (genre.value == "") {
		alert("Select one genre");
		flag = 1;
		return false;
	}
	if (titleName == null || titleName == "") {
		alert("Title cannot be empty");
		document.movieItem.title.focus();
		flag = 1;
		return false;
	}
	if (isNaN(boxOffice)) {
		alert("Box Office has to be a number");
		document.movieItem.boxOffice.focus();
		flag = 1;
		return false;
	}
	if (titleName.length < 2 || titleName.length > 100) {
		alert("Title should have 2 to 100 characters");
		document.movieItem.title.focus();
		flag = 1;
		return false;
	}
	if (flag == 0)
		return true;
	return true;
}
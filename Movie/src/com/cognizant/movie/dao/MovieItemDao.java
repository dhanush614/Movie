package com.cognizant.movie.dao;

import java.util.List;
import com.cognizant.movie.model.MovieItem;

public interface MovieItemDao {
	public List<MovieItem> getMovieItemListAdmin();

	public void modifyMovieItem(MovieItem movieItem);

	public MovieItem getMovieItem(long movieItemId);

}

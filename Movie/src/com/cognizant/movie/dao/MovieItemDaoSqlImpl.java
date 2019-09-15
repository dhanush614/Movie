package com.cognizant.movie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.movie.model.MovieItem;
import com.cognizant.movie.dao.ConnectionHandler;

public class MovieItemDaoSqlImpl implements MovieItemDao {
	Connection connection = ConnectionHandler.getConnection();
	ResultSet rs = null;
	PreparedStatement stmt = null;

	public MovieItemDaoSqlImpl() {
		super();
	}

	@Override
	public List<MovieItem> getMovieItemListAdmin() {
		// TODO Auto-generated method stub
		List<MovieItem> movieList = new ArrayList<MovieItem>();
		try {
			stmt = connection.prepareStatement(
					"select mo_id, mo_title, mo_box_office, mo_active, mo_date_of_launch, mo_genre, mo_has_teaser from movie_list;");
			try {
				rs = stmt.executeQuery();
				while (rs.next()) {
					MovieItem movieItem = new MovieItem();
					movieItem.setId(rs.getLong(1));
					movieItem.setTitle(rs.getString(2));
					movieItem.setBoxOffice(rs.getString(3));
					String active = rs.getString(4);
					if (active.equals("Yes")) {
						movieItem.setActive(true);
					} else {
						movieItem.setActive(false);
					}
					movieItem.setDateOfLaunch(rs.getDate(5));
					movieItem.setGenre(rs.getString(6));
					String free_delivery = rs.getString(7);
					if (free_delivery.equals("Yes")) {
						movieItem.setHasTeaser(true);
					} else {
						movieItem.setHasTeaser(false);
					}
					movieList.add(movieItem);
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			} finally {
				rs.close();
				stmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return movieList;
	}

	@Override
	public void modifyMovieItem(MovieItem movieItem) {
		// TODO Auto-generated method stub
		try {
			stmt = connection.prepareStatement(
					"update movie_list set mo_title = ?, mo_box_office = ?, mo_active = ?, mo_date_of_launch = ?, mo_genre = ?, mo_has_teaser = ? where mo_id = ?");
			try {
				stmt.setString(1, movieItem.getTitle());
				stmt.setString(2, movieItem.getBoxOffice());
				if (movieItem.isActive())
					stmt.setString(3, "Yes");
				else
					stmt.setString(3, "No");
				Date date = movieItem.getDateOfLaunch();
				java.sql.Date sqlDate = new java.sql.Date(date.getTime());
				stmt.setDate(4, sqlDate);
				stmt.setString(5, movieItem.getGenre());
				if (movieItem.isHasTeaser())
					stmt.setString(6, "Yes");
				else
					stmt.setString(6, "No");
				stmt.setInt(7, (int) movieItem.getId());
				stmt.executeUpdate();
			} catch (SQLException ex) {
				ex.printStackTrace();
			} finally {
				stmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public MovieItem getMovieItem(long movieItemId) {
		// TODO Auto-generated method stub
		MovieItem movieItem = new MovieItem();
		try {
			stmt = connection.prepareStatement(
					"select mo_id, mo_title, mo_box_office, mo_active, mo_date_of_launch, mo_genre , mo_has_teaser from movie_list where mo_id = ?");
			try {
				stmt.setInt(1, (int) movieItemId);
				rs = stmt.executeQuery();
				if (rs.next()) {
					movieItem.setId(rs.getLong(1));
					movieItem.setTitle(rs.getString(2));
					movieItem.setBoxOffice(rs.getString(3));
					String active = rs.getString(4);
					if (active.equals("Yes")) {
						movieItem.setActive(true);
					} else {
						movieItem.setActive(false);
					}
					movieItem.setDateOfLaunch(rs.getDate(5));
					movieItem.setGenre(rs.getString(6));
					String free_delivery = rs.getString(7);
					if (free_delivery.equals("Yes")) {
						movieItem.setHasTeaser(true);
					} else {
						movieItem.setHasTeaser(false);
					}
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			} finally {
				rs.close();
				stmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return movieItem;
	}

}

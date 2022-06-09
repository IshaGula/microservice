package io.javabrainstutorial.moviecatalogservice.models;

import java.util.List;

public class UserRatings {
	
	public UserRatings(List<Rating> ratings) {
		super();
		this.ratings = ratings;
	}

	public UserRatings() {
		super();
		// TODO Auto-generated constructor stub
	}

	private List<Rating> ratings;

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
	
	

}

package io.javabrainstutorial.ratingsdataservice.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javabrainstutorial.ratingsdataservice.models.Rating;
import io.javabrainstutorial.ratingsdataservice.models.UserRatings;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsDataResources {

	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId) {
		return new Rating(movieId,4);
	}
	
	@RequestMapping("users/{userId}")
	public UserRatings getMoviesRatings(@PathVariable("userId") String userId) {
		List<Rating> ratings = Arrays.asList(
				new Rating("check1",2),
				new Rating("check2",5)
				);
		UserRatings userRatings = new UserRatings();
		userRatings.setRatings(ratings);
		return userRatings;
	}
	
}

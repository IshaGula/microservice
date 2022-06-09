package io.javabrainstutorial.moviecatalogservice.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.javabrainstutorial.moviecatalogservice.models.CatalogItem;
import io.javabrainstutorial.moviecatalogservice.models.Movie;
import io.javabrainstutorial.moviecatalogservice.models.UserRatings;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResources {
	
	@Autowired
	private RestTemplate restTemplate;
	
//	@Autowired
//	private WebClient.Builder webClientBuilder;

	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
	
		
//		List<CatalogItem> c = new ArrayList<>();
		UserRatings ratings = restTemplate.getForObject("http://ratings-data-service/ratingsdata/users/"+userId, UserRatings.class);
		
		return ratings.getRatings().stream().map(rating->{
			Movie m = restTemplate.getForObject("http://movie-info-service/movies/"+rating.getMovieId(), Movie.class);
			
			return new CatalogItem(m.getMovieId(),m.getName(),rating.getRating());
		}).collect(Collectors.toList());
		

	};
	
}



/*		for(Rating r:ratings) {
		Movie m = restTemplate.getForObject("http://localhost:8082/movies/"+r.getMovieId(), Movie.class);
		c.add(new CatalogItem(m.getMovieId(),"testdesc",r.getRating()));
	}
return c; 
*/




/* Movie m = webClientBuilder.build()
				.get()
				.uri("http://localhost:8082/movies/"+rating.getMovieId())
				.retrieve()
				.bodyToMono(Movie.class)
				.block();
*/
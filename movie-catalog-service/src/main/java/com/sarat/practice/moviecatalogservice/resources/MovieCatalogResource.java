package com.sarat.practice.moviecatalogservice.resources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sarat.practice.moviecatalogservice.models.CatalogItem;
import com.sarat.practice.moviecatalogservice.models.Movie;
import com.sarat.practice.moviecatalogservice.models.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	//																	     <--
	//Movie Info Service (movieId) --> Movie Object --> movieId, movie Name     //Rating Data Service (movieId) --> Rating object --> movieId, rating 
	
			//Movie Catalog Service (userId) --> List<CatalogItem> --> movie name, desc, rating
	
	@Autowired
	private RestTemplate restTemplate;
	
	//@Autowired
	//private WebClient.Builder webClientBuilder;
	
	@RequestMapping("/{userId}")
	@HystrixCommand(fallbackMethod = "getFallbackCatalog")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		
		//RestTemplate restTemplate = new RestTemplate();
		//webclient for asynchronus call
		
		//WebClient.Builder builder = WebClient.builder();
		
		
		//get all rated movie ids 
		/*
		 * List<Rating> ratings = Arrays.asList( new Rating("1234", 4), new
		 * Rating("5678", 3) );
		 */
		
		UserRating ratings = restTemplate.getForObject("http://rating-data-service/ratingsdata/users/"+userId, UserRating.class);
		
		return ratings.getUserRating().stream().map(rating -> {
			//for each movie id call the movie info service and get the details
			Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
			//put all them together				
			return new CatalogItem(movie.getName(), "Desc", rating.getRating());
	})
				.collect(Collectors.toList());
	}
	
	public List<CatalogItem> getFallbackCatalog(@PathVariable("userId") String userId){
		return Arrays.asList(new CatalogItem("No Movie", "", 0));
	}
}


/*
  Movie movie = webClientBuilder.build() 
  								.get()
  								.uri("http://localhost:8082/movies/" + rating.getMovieId()) .retrieve()
 								.bodyToMono(Movie.class) .block();
 */
package io.javabrains.moviecatalogservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
    @Autowired
    private RestTemplate restTemplate;

//    @Autowired
//    private WebClient.Builder webClientBuilder;

    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
        //Movie movie = restTemplate.getForObject("http://localhost:8081/movies/foo", Movie.class);
//        List<Rating> ratings = Arrays.asList(
//                new Rating("123",2),
//                new Rating("5678",3)
//        );
        UserRating ratings = restTemplate.getForObject("http://movie-rating-service/ratingsdata/user/" + userId, UserRating.class);
        return ratings.getRatings().stream().map(rating->{
                Movie mov = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
//            Movie mov = webClientBuilder.build()
//                    .get()
//                    .uri("http://localhost:8081/movies/" + rating.getMovieId())
//                    .retrieve()
//                    .bodyToMono(Movie.class)
//                    .block();
//
            return new CatalogItem(mov.getName(), mov.getDescription(), rating.getRating());
                //new CatalogItem("transformers","Test",2)).collect(Collectors.toList());
                }).collect(Collectors.toList());
       // return Collections.singletonList(new CatalogItem("Transformsers","Test",1));
    }

}

package BookMyShow.bookmyshow.Services;

import BookMyShow.bookmyshow.Models.Movie;
import BookMyShow.bookmyshow.Repositories.MovieRepository;
import BookMyShow.bookmyshow.Requests.AddMovieRequest;
import BookMyShow.bookmyshow.Requests.UpdateMovieRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;
    public String addMovie(AddMovieRequest movieRequest) {
//        return movieRepository.save(movie);

        Movie movie=  new Movie();
        movie.setMovieName(movieRequest.getMovieName());
        movie.setDuration(movieRequest.getDuration());
        movie.setReleaseDate(movieRequest.getReleaseDate());
        movie.setRating(movieRequest.getRating());
        movie.setLanguage(movieRequest.getLanguage());


        movie =  movieRepository.save(movie);
        return  "Movie has been added to the DB with movieId "+movie.getMovie_id();
    }

    public String updateMovieAttributes(UpdateMovieRequest movieRequest){

        //Get the movie Entity
        Movie movies = movieRepository.findMovieByMovieName(movieRequest.getMovieName());

        //Get value from hashmap

        //Update the new attributes
        movies.setLanguage(movieRequest.getNewLanguage());
        movies.setRating(movieRequest.getNewRating());

        //update the value

        // Save it back to DB
        movieRepository.save(movies);

        //put it back to HM
        return "Movie Attributes have been updated ";
    }
}

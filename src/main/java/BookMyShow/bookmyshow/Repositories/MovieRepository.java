package BookMyShow.bookmyshow.Repositories;

import BookMyShow.bookmyshow.Models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Integer>{

        Movie findMovieByMovieName(String movieName);

}

package BookMyShow.bookmyshow.Controller;

import BookMyShow.bookmyshow.Models.Movie;
import BookMyShow.bookmyshow.Requests.AddMovieRequest;
import BookMyShow.bookmyshow.Requests.UpdateMovieRequest;
import BookMyShow.bookmyshow.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("add")
    public ResponseEntity addMovie(@RequestBody AddMovieRequest movieRequest){
//        try {
//            String result = movieService.add(movie);
//            HttpResponse(result, HttpStatus.OK);
//        }
//        catch(Exception e){
//            HttpResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
//            }
        String response = movieService.addMovie(movieRequest);
        return new ResponseEntity(response,HttpStatus.OK);
        }



    @PutMapping("update")
    public ResponseEntity updateMovieAttributes(@RequestBody UpdateMovieRequest updateMovieRequest){

        String response = movieService.updateMovieAttributes(updateMovieRequest);
        return new ResponseEntity(response,HttpStatus.OK);
    }








//        @PutMapping("update")
//        public ResponseEntity upadateMovieAttributes(@RequestBody UpdateMovieRequest movieRequest){
//
//        try {
//            String response = movieService.updateMovie((movieRequest));
//            return new ResponseEntity(response, HttpStatus.OK);
//        }
//        catch (Exception e){
//            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
//        }
//            return  "movie details has been update sucessfully"+response;

        }





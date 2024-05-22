package BookMyShow.bookmyshow.Controller;

import BookMyShow.bookmyshow.Requests.AddTheaterRequest;
import BookMyShow.bookmyshow.Requests.AddTheaterSeatsRequest;
import BookMyShow.bookmyshow.Services.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("theater")
public class TheaterController {
    @Autowired
    private TheaterService theaterService;

    @PostMapping("add")
    public ResponseEntity addTheater(@RequestBody  AddTheaterRequest theaterRequest){
        String response = theaterService.addTheater(theaterRequest);
        return new ResponseEntity(response, HttpStatus.OK);
    }
    @PutMapping("associateSeats")
    public ResponseEntity associateSeats(@RequestBody AddTheaterSeatsRequest theaterSeatsRequest){

        String response = theaterService.associateTheaterSeats(theaterSeatsRequest);
        return new ResponseEntity(response,HttpStatus.OK);
    }

}

package BookMyShow.bookmyshow.Services;

import BookMyShow.bookmyshow.Models.Movie;
import BookMyShow.bookmyshow.Models.Show;
import BookMyShow.bookmyshow.Models.Theater;
import BookMyShow.bookmyshow.Models.TheaterSeat;
import BookMyShow.bookmyshow.Repositories.MovieRepository;
import BookMyShow.bookmyshow.Repositories.ShowRepository;
import BookMyShow.bookmyshow.Repositories.ShowSeatRepository;
import BookMyShow.bookmyshow.Repositories.TheaterRepository;
import BookMyShow.bookmyshow.Requests.AddShowRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ShowSeatRepository showSeatRepository;

    public String addShow(AddShowRequest showRequest) {

        Movie movie = movieRepository.findMovieByMovieName(showRequest.getMovieName());
        Theater theater = theaterRepository.findById(showRequest.getTheaterId()).get();

        //Add validations on if movie and theater are valid scenarios
        Show show = Show.builder().showDate(showRequest.getShowDate())
                .showTime(showRequest.getShowTime())
                .movie(movie)
                .theater(theater)
                .build();
        show = showRepository.save(show);


        //Associate the corresponding show Seats along with it
        List<TheaterSeat> theaterSeatList = theater.getTheaterSeatList();

//        List<ShowSeat> showSeatList = new ArrayList<>();
//
//        for (TheaterSeat theaterSeat : theaterSeatList) {
//
//            ShowSeat showSeat = ShowSeat.builder().seatNo(theaterSeat.getSeatNo())
//                    .seatType(theaterSeat.getSeatType())
//                    .isBooked(Boolean.FALSE)
//                    .isFoodAttached(Boolean.FALSE)
//                    .show(show)
//                    .build();
//            showSeatList.add(showSeat);
//        }

//        showSeatRepository.saveAll(showSeatList);
        return "The show has been saved to the DB with showId " + show.getShowId();
    }
}
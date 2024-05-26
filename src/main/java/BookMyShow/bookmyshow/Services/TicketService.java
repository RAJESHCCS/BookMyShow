package BookMyShow.bookmyshow.Services;

import BookMyShow.bookmyshow.Enums.SeatType;
import BookMyShow.bookmyshow.Models.Show;
import BookMyShow.bookmyshow.Models.ShowSeat;
import BookMyShow.bookmyshow.Models.Ticket;
import BookMyShow.bookmyshow.Models.User;
import BookMyShow.bookmyshow.Repositories.ShowRepository;
import BookMyShow.bookmyshow.Repositories.ShowSeatRepository;
import BookMyShow.bookmyshow.Repositories.TicketRepository;
import BookMyShow.bookmyshow.Repositories.UserRepository;
import BookMyShow.bookmyshow.Requests.BookTicketRequest;
import BookMyShow.bookmyshow.Responses.TicketResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private ShowSeatRepository showSeatRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TicketRepository  ticketRepository;

    public String bookTicket(BookTicketRequest bookTicketRequest){

        //1. Find the Show Entity
        Show show = showRepository.findById(bookTicketRequest.getShowId()).get();

        //2. Find the User Entity
        User user = userRepository.findById(bookTicketRequest.getUserId()).get();

        //3. Mark those Seats as booked now and calculate total Amount
        Integer totalAmount = 0;
        List<ShowSeat> showSeatList = show.getShowSeatList();

        for(ShowSeat showSeat : showSeatList) {

            String seatNo = showSeat.getSeatNo();
            if(bookTicketRequest.getRequestedSeats().contains(seatNo)) {
                showSeat.setIsBooked(Boolean.TRUE);

                if(showSeat.getSeatType().equals(SeatType.Classic))
                    totalAmount = totalAmount + 100;
                else
                    totalAmount = totalAmount+150;
            }
        }
        showSeatRepository.saveAll(showSeatList);
        //4. Create the Ticket Entity and set the attributes
        Ticket ticket = Ticket.builder().showDate(show.getShowDate())
                .showTime(show.getShowTime())
                .movieName(show.getMovie().getMovieName())
                .theaterName(show.getTheater().getName())
                .totalAmount(totalAmount)
                .bookedSeats(bookTicketRequest.getRequestedSeats().toString())
                .show(show)
                .user(user)
                .build();



        ticket = ticketRepository.save(ticket);
        //5. save the ticket into DB and return Ticket Entity (Ticket Response)
        return ticket.getTicketId();
    }

    public TicketResponse generateTicket(String ticketId){

        Ticket ticket = ticketRepository.findById(ticketId).get();

        //Entity needs to be converted into TicketResponse

        TicketResponse ticketResponse = TicketResponse.builder()
                .bookedSeats(ticket.getBookedSeats())
                .movieName(ticket.getMovieName())
                .showTime(ticket.getShowTime())
                .showDate(ticket.getShowDate())
                .theaterName(ticket.getTheaterName())
                .totalAmount(ticket.getTotalAmount())
                .build();

        return ticketResponse;

    }

}
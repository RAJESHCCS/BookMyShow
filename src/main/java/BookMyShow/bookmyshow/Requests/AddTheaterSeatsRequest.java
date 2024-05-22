package BookMyShow.bookmyshow.Requests;

import lombok.Data;

@Data
public class AddTheaterSeatsRequest {
//DTO are custome class help to send data to controller , whithou

    private Integer theaterId;
    private Integer noOfClassicSeats;
    private Integer noOfPremiumSeats;



}

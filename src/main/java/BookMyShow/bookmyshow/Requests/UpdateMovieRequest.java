package BookMyShow.bookmyshow.Requests;

import BookMyShow.bookmyshow.Enums.Language;
import lombok.Data;

@Data
public class UpdateMovieRequest {

    private String movieName;
    private Language newLanguage;
    private Double newRating;

}
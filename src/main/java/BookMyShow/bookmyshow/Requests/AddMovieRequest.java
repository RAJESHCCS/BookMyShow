package BookMyShow.bookmyshow.Requests;

import BookMyShow.bookmyshow.Enums.Language;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AddMovieRequest {
    private String movieName;
    private Double duration;
    private LocalDate releaseDate;
    private Language language;
    private Double rating;

}

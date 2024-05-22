package BookMyShow.bookmyshow.Models;


import BookMyShow.bookmyshow.Enums.Language;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name="movies")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movie_id;
    @Column(unique = true)
    private String movieName;

    private double duration;
    private LocalDate releaseDate;

    @Enumerated(value=EnumType.STRING)
    private Language language;
    private  double rating;



}

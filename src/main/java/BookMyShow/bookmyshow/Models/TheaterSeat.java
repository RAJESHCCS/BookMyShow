package BookMyShow.bookmyshow.Models;


import BookMyShow.bookmyshow.Enums.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="theator_seats")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TheaterSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer theaterId;

    private String seatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    @JoinColumn
    @ManyToOne
    private Theater theater;





}

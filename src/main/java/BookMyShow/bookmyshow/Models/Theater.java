package BookMyShow.bookmyshow.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="theaters")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer theaterId;
    private String name;
    private String address;
    private Integer noOfScreen;
    //Bidirectional mapping in the parent to keep a record of the child
    @OneToMany(mappedBy = "theater",cascade = CascadeType.ALL)
    private List<TheaterSeat> theaterSeatList = new ArrayList<>();
}
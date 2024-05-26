package BookMyShow.bookmyshow.Repositories;

import BookMyShow.bookmyshow.Models.Show;
import BookMyShow.bookmyshow.Models.ShowSeat;
import BookMyShow.bookmyshow.Models.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowSeatRepository extends JpaRepository<ShowSeat,Integer> {


}

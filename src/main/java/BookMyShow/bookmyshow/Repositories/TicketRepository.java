package BookMyShow.bookmyshow.Repositories;

import BookMyShow.bookmyshow.Models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {
}

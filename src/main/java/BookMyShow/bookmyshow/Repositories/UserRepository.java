package BookMyShow.bookmyshow.Repositories;

import BookMyShow.bookmyshow.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}

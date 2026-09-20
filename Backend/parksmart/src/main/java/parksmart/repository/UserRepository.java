package parksmart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import parksmart.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);
}
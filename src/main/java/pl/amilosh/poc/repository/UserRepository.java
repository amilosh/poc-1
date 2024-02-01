package pl.amilosh.poc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.amilosh.poc.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}

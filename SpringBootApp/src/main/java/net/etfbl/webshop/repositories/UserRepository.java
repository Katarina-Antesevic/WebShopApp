package net.etfbl.webshop.repositories;

import net.etfbl.webshop.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import net.etfbl.webshop.exceptions.NotFoundException;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Boolean existsByUsername(String username);

    Optional<User> findByUsername(String username) throws NotFoundException;

    boolean existsByUsernameAndIdNot(String username, Integer integer);
}

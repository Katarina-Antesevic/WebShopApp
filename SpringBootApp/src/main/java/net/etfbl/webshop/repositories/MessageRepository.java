package net.etfbl.webshop.repositories;

import net.etfbl.webshop.models.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {
}

package net.etfbl.webshop.repositories;

import net.etfbl.webshop.models.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Integer> {
}

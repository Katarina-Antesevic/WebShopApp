package net.etfbl.webshop.repositories;

import net.etfbl.webshop.models.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}

package net.etfbl.webshop.repositories;

import net.etfbl.webshop.models.entities.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentTypeRepository extends JpaRepository<PaymentType, Integer> {
    Boolean existsByName(String name);

    Boolean existsByNameAndIdNot(String name, Integer id);
}

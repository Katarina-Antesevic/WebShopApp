package net.etfbl.webshop.repositories;

import net.etfbl.webshop.models.entities.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {

    @Query("SELECT p FROM Purchase p WHERE p.user.id=:id")
    List<Purchase> searchByIdUser(Integer id);

}

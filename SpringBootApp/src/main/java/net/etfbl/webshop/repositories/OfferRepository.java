package net.etfbl.webshop.repositories;

import net.etfbl.webshop.models.entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OfferRepository extends JpaRepository<Offer, Integer> {


    @Query("SELECT o FROM Offer o WHERE o.product.category.id=:id")
    List<Offer> searchByCategoryId(Integer id);

    @Query("SELECT o FROM Offer o WHERE o.idUser=:id")
    List<Offer> searchByIdUser(Integer id);

    @Query("SELECT o FROM Offer o WHERE o.isActive=true")
    List<Offer> findAllExisting();
}

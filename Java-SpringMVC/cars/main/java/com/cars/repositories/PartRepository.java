package com.cars.repositories;

import com.cars.entities.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PartRepository extends JpaRepository<Part, Long> {

    @Query("UPDATE parts AS p SET p.price =:price, p.quantity =:quantity WHERE p.id =:id")
    void update(@Param("price") Double price, @Param("quantity") Long quantity, @Param("id") Long id);
}

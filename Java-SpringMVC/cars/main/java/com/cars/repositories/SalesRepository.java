package com.cars.repositories;

import com.cars.entities.Sale;
import com.cars.models.viewModels.SaleViewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesRepository extends JpaRepository<Sale, Long> {

    List<Sale> findAllByCustomerId(long customerId);

    List<Sale> findAllByDiscount(double discount);
}

package com.cars.servicies;


import com.cars.models.viewModels.SaleViewModel;

import java.util.List;

public interface SaleService {


    List<SaleViewModel> getAllSales();

    SaleViewModel findById(long id);

    List<SaleViewModel> findAllDiscountedSales();

    List<SaleViewModel> findSalesByPercentage(double percentage);
}

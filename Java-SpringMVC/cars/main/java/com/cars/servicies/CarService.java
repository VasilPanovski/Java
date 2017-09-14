package com.cars.servicies;


import com.cars.models.bindingModels.AddCarModel;
import com.cars.models.viewModels.CarWithPartsViewModel;
import com.cars.models.viewModels.CarsViewModel;
import com.cars.models.viewModels.CustomerSalesViewModel;
import com.cars.models.viewModels.PartViewModel;

import java.util.List;

public interface CarService {

    List<CarsViewModel> findAllCarsByMake(String make);

    List<CarWithPartsViewModel> findAllCarsWithinParts();

    CarWithPartsViewModel findCarById(long id);

    void save(AddCarModel addCarModel);
}

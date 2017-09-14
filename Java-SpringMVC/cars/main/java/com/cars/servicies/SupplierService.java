package com.cars.servicies;

import com.cars.models.bindingModels.SupplierModel;
import com.cars.models.viewModels.SupplierViewModel;

import java.util.List;

public interface SupplierService {

    List<SupplierViewModel> findLocalSuppliers();

    List<SupplierViewModel> findImportersSuppliers();

    List<SupplierViewModel> findAll();

    SupplierModel findByName(String supplierName);
}

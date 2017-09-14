package com.cars.servicies;

import com.cars.models.bindingModels.AddCustomerModel;
import com.cars.models.bindingModels.EditCustomerModel;
import com.cars.models.viewModels.CustomerSalesViewModel;
import com.cars.models.viewModels.CustomersViewModel;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CustomerService {

    List<CustomersViewModel> findAllAsc();

    List<CustomersViewModel> findAllDesc();

    CustomerSalesViewModel findById(long id);

    boolean save(AddCustomerModel addCustomerModel);

    EditCustomerModel findByIdForEdit(long id);

    boolean update(EditCustomerModel editCustomerModel);
}

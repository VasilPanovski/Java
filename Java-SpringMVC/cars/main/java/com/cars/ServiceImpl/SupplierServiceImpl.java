package com.cars.ServiceImpl;

import com.cars.entities.Supplier;
import com.cars.models.bindingModels.SupplierModel;
import com.cars.models.viewModels.SupplierViewModel;
import com.cars.repositories.SupplierRepository;
import com.cars.servicies.SupplierService;
import com.cars.utils.modelParser.interfaces.ModelParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private ModelParser modelParser;

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public List<SupplierViewModel> findLocalSuppliers() {
        List<Supplier> suppliers = this.supplierRepository.findAllByIsImporterFalse();

        List<SupplierViewModel> supplierViewModels = new ArrayList<>(suppliers.size());
        for (Supplier supplier : suppliers) {
            SupplierViewModel supplierViewModel = this.modelParser.convert(supplier, SupplierViewModel.class);
            supplierViewModels.add(supplierViewModel);
        }

        return supplierViewModels;
    }

    @Override
    public List<SupplierViewModel> findImportersSuppliers() {
        List<Supplier> suppliers = this.supplierRepository.findAllByIsImporterTrue();

        List<SupplierViewModel> supplierViewModels = new ArrayList<>(suppliers.size());
        for (Supplier supplier : suppliers) {
            SupplierViewModel supplierViewModel = this.modelParser.convert(supplier, SupplierViewModel.class);
            supplierViewModels.add(supplierViewModel);
        }

        return supplierViewModels;
    }

    @Override
    public List<SupplierViewModel> findAll() {
        List<Supplier> suppliers = this.supplierRepository.findAll();
        List<SupplierViewModel> supplierViewModels = new ArrayList<>(suppliers.size());

        SupplierViewModel supplierViewModel = null;
        for (Supplier supplier : suppliers) {
            supplierViewModel = this.modelParser.convert(supplier, SupplierViewModel.class);
            supplierViewModels.add(supplierViewModel);
        }

        return supplierViewModels;
    }

    @Override
    public SupplierModel findByName(String supplierName) {
        Supplier supplier = this.supplierRepository.findOneByName(supplierName);
        SupplierModel supplierModel = this.modelParser.convert(supplier, SupplierModel.class);

        return supplierModel;
    }
}

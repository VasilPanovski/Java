package com.cars.ServiceImpl;

import com.cars.entities.Part;
import com.cars.entities.Sale;
import com.cars.models.viewModels.SaleViewModel;
import com.cars.repositories.SalesRepository;
import com.cars.servicies.SaleService;
import com.cars.utils.modelParser.interfaces.ModelParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SalesRepository salesRepository;

    @Autowired
    private ModelParser modelParser;

    @Override
    public List<SaleViewModel> getAllSales() {
        List<Sale> sales = this.salesRepository.findAll();
        List<SaleViewModel> saleModels = new ArrayList<>(sales.size());

        SaleViewModel saleViewModel = null;
        double priceWithDiscount = 0;
        double priceWithoutDiscount = 0;
        for (Sale sale : sales) {
            saleViewModel = this.modelParser.convert(sale, SaleViewModel.class);
            for (Part part : sale.getCar().getParts()) {
                priceWithoutDiscount += part.getPrice();
            }

            priceWithDiscount = priceWithoutDiscount + (priceWithoutDiscount * sale.getDiscount()) / 100;
            saleViewModel.setPriceWithDiscount(priceWithDiscount);
            saleViewModel.setPriceWithoutDiscount(priceWithoutDiscount);

            saleModels.add(saleViewModel);
        }

        return saleModels;
    }

    @Override
    public SaleViewModel findById(long id) {
        Sale sale = this.salesRepository.findOne(id);

        SaleViewModel saleViewModel = null;
        if (sale != null) {
            saleViewModel = this.modelParser.convert(sale, SaleViewModel.class);
        }

        return saleViewModel;
    }

    @Override
    public List<SaleViewModel> findAllDiscountedSales() {
        List<SaleViewModel> allSales = this.getAllSales().stream().filter(s -> s.getDiscount() != 0).collect(Collectors.toList());
        return allSales;
    }

    @Override
    public List<SaleViewModel> findSalesByPercentage(double percentage) {
        List<Sale> sales = this.salesRepository.findAllByDiscount(percentage);
        if (sales == null || sales.isEmpty()) {
            return null;
        }

        List<SaleViewModel> saleViewModels = new ArrayList<>(sales.size());

        SaleViewModel saleModel = null;
        for (Sale sale : sales) {
            saleModel = this.modelParser.convert(sale, SaleViewModel.class);
            saleViewModels.add(saleModel);
        }

        return saleViewModels;
    }
}

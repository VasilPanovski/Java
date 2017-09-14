package com.cars.ServiceImpl;

import com.cars.entities.Customer;
import com.cars.entities.Part;
import com.cars.entities.Sale;
import com.cars.models.bindingModels.AddCustomerModel;
import com.cars.models.bindingModels.EditCustomerModel;
import com.cars.models.viewModels.CustomerSalesViewModel;
import com.cars.models.viewModels.CustomersViewModel;
import com.cars.repositories.CustomerRepository;
import com.cars.repositories.SalesRepository;
import com.cars.servicies.CustomerService;
import com.cars.utils.modelParser.interfaces.ModelParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private SalesRepository salesRepository;

    @Autowired
    private ModelParser modelParser;

    @Override
    public List<CustomersViewModel> findAllAsc() {
        List<Customer> customers = this.customerRepository.findAllByOrderByBirthDateAscIsYoungDriverAsc();
        List<CustomersViewModel> customersViewModels = new ArrayList<>(customers.size());

        for (Customer customer : customers) {
            CustomersViewModel customersViewModel = this.modelParser.convert(customer, CustomersViewModel.class);
            customersViewModels.add(customersViewModel);
        }

        return customersViewModels;
    }

    @Override
    public List<CustomersViewModel> findAllDesc() {
        List<Customer> customers = this.customerRepository.findAllByOrderByBirthDateDescIsYoungDriverAsc();
        List<CustomersViewModel> customersViewModels = new ArrayList<>(customers.size());

        for (Customer customer : customers) {
            CustomersViewModel customersViewModel = this.modelParser.convert(customer, CustomersViewModel.class);
            customersViewModels.add(customersViewModel);
        }

        return customersViewModels;
    }

    @Override
    public CustomerSalesViewModel findById(long id) {
        Customer customer = this.customerRepository.findOne(id);
        if (customer == null) {
            return null;
        }

        int totalCars = customer.getSales().size();
        double totalPrice = 0;
        for (Sale sale : customer.getSales()) {
            totalPrice = sale.getCar().getParts().stream().mapToDouble(Part::getPrice).sum();
            totalPrice += (totalPrice * sale.getDiscount()) / 100;
        }

        CustomerSalesViewModel customerSalesViewModel = this.modelParser.convert(customer, CustomerSalesViewModel.class);
        customerSalesViewModel.setTotalSpentMoney(totalPrice);
        customerSalesViewModel.setBoughtCarsCount(totalCars);

        return customerSalesViewModel;
    }

    @Override
    public boolean save(AddCustomerModel addCustomerModel) {
        Customer customer = new Customer();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        sdf.setLenient(false);


        Date birthDate = null;
        try {
            birthDate = sdf.parse(addCustomerModel.getBirthDate());
        } catch (ParseException e) {
            return false;
        }

        customer.setName(addCustomerModel.getName());
        customer.setBirthDate(birthDate);
        customer.setIsYoungDriver(isYoungerDriver(birthDate));

        this.customerRepository.saveAndFlush(customer);
        return true;
    }

    @Override
    public EditCustomerModel findByIdForEdit(long id) {
        Customer customer = this.customerRepository.findOne(id);

        return this.modelParser.convert(customer, EditCustomerModel.class);
    }

    @Override
    public boolean update(EditCustomerModel editCustomerModel) {
        Customer customer = new Customer();
        customer.setId(editCustomerModel.getId());
        customer.setName(editCustomerModel.getName());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        Date birthDate = null;
        try {
            birthDate = sdf.parse(editCustomerModel.getBirthDate());
            customer.setBirthDate(birthDate);
        } catch (ParseException e) {
            return false;
        }

        customer.setIsYoungDriver(this.isYoungerDriver(birthDate));
        this.customerRepository.saveAndFlush(customer);
        return true;
    }

    private boolean isYoungerDriver(Date birthDate) {
        boolean isYoungDriver = false;

        Date now = new Date();
        long from = now.getTime();
        long to = birthDate.getTime();
        long diff = from - to;

        diff /= (24 * 60 * 60 * 1000 * 365);
        if (diff < 20) {
            isYoungDriver = true;
        }

        return isYoungDriver;
    }
}

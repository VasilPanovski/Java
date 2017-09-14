package com.cars.ServiceImpl;

import com.cars.entities.Car;
import com.cars.entities.Customer;
import com.cars.entities.Part;
import com.cars.models.bindingModels.AddCarModel;
import com.cars.models.viewModels.*;
import com.cars.repositories.CarRepository;
import com.cars.servicies.CarService;
import com.cars.utils.modelParser.interfaces.ModelParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private ModelParser modelParser;

    @Override
    public List<CarsViewModel> findAllCarsByMake(String make) {
        List<Car> cars = null;
        if (make != null) {
            cars = this.carRepository.findAllByMakeOrderByModelAscTravelledDistanceDesc(make);
        } else {
            cars = this.carRepository.findAll();
        }

        List<CarsViewModel> carsViewModels = new ArrayList<>(cars.size());
        for (Car car : cars) {
            CarsViewModel carsViewModel = this.modelParser.convert(car, CarsViewModel.class);
            carsViewModels.add(carsViewModel);
        }

        return carsViewModels;
    }

    @Override
    public List<CarWithPartsViewModel> findAllCarsWithinParts() {
        List<Car> cars = this.carRepository.findAll();
        List<CarWithPartsViewModel> carWithPartsViewModels = new ArrayList<>(cars.size());

        CarWithPartsViewModel carWithPartsViewModel = null;
        CarPartsViewModel carPartsViewModel = null;

        for (Car car : cars) {
            carWithPartsViewModel = this.modelParser.convert(car, CarWithPartsViewModel.class);

            List<CarPartsViewModel> carPartsViewModels = new ArrayList<>(car.getParts().size());
            for (Part part : car.getParts()) {
                carPartsViewModel = this.modelParser.convert(part, CarPartsViewModel.class);
                carPartsViewModels.add(carPartsViewModel);
            }

            carWithPartsViewModel.setParts(carPartsViewModels);
            carWithPartsViewModels.add(carWithPartsViewModel);
        }

        return carWithPartsViewModels;
    }

    @Override
    public CarWithPartsViewModel findCarById(long id) {
        int totalCars = this.carRepository.findAll().size();
        if (id > totalCars) {
            return null;
        }

        Car car = this.carRepository.findOne(id);
        List<CarPartsViewModel> carPartsViewModels = new ArrayList<>();
        CarPartsViewModel carPartsViewModel = null;

        for (Part part : car.getParts()) {
            carPartsViewModel = this.modelParser.convert(part, CarPartsViewModel.class);
            carPartsViewModels.add(carPartsViewModel);
        }

        CarWithPartsViewModel carWithPartsViewModel = this.modelParser.convert(car, CarWithPartsViewModel.class);
        carWithPartsViewModel.setParts(carPartsViewModels);

        return carWithPartsViewModel;
    }

    @Override
    public void save(AddCarModel addCarModel) {
        Car car = this.modelParser.convert(addCarModel, Car.class);
        this.carRepository.saveAndFlush(car);
    }
}

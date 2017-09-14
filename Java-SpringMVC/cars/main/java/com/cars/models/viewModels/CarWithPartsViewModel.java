package com.cars.models.viewModels;


import java.util.ArrayList;
import java.util.List;

public class CarWithPartsViewModel {

    private long id;

    private String make;

    private String model;

    private long travelledDistance;

    private List<CarPartsViewModel> parts;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CarWithPartsViewModel() {
        this.parts = new ArrayList<>();
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public List<CarPartsViewModel> getParts() {
        return parts;
    }

    public void setParts(List<CarPartsViewModel> parts) {
        this.parts = parts;
    }
}

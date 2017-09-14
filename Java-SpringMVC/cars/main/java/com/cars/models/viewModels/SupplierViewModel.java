package com.cars.models.viewModels;


import com.cars.entities.Part;

import java.util.List;

public class SupplierViewModel {

    private long id;

    private String name;

    private List<Part> parts;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }
}

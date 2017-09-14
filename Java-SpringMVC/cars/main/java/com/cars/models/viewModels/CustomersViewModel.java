package com.cars.models.viewModels;

import java.util.Date;

public class CustomersViewModel {

    private long id;

    private String name;

    private Date birthDate;

    private boolean youngDriver;

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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isYoungDriver() {
        return youngDriver;
    }

    public void setYoungDriver(boolean youngDriver) {
        this.youngDriver = youngDriver;
    }
}
